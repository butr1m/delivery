'use strict';
const app = angular.module('MiniApp', []);
app.controller('todayCtrl', function ($scope, $http) {
    $scope.orders = [];
    $scope.phoneNumberPattern = '\\+?\\d{3}-\\d{2}-\\d{7}';

    $scope.init = function () {
        $scope.getOrderOnToday();
    }

    $scope.getOrderOnToday = function () {
        $http.get('/order-rest/get-order-on-today')
            .then(function onSuccess(response) {
                let obj = response.data;
                if (obj) {
                    $scope.orders = obj;
                    makeOrdersInfo();
                }
            });
    }

    $scope.onChangeDeliveryStatus = function (order) {
        let _order = angular.copy(order);
        _order.delivered = !order.delivered;
        $http.put('/order-rest/change-delivery-status', _order)
            .then(function onSuccess(response) {
                let obj = response.data;
                if (obj) {
                    let index = $scope.orders.findIndex(el => el.id === obj.id);
                    if (index > -1) {
                        $scope.orders[index] = obj;
                    }
                    makeOrdersInfo();
                }
            });
    }

    $scope.onShowEditOrderModal = function (order) {
        if (order) {
            $scope._order = angular.copy(order);
            $scope._order.deliveryDate = new Date($scope._order.deliveryDate)
        } else {
            $scope._order = {
                id: null,
                clientName: '',
                phoneNumber: '',
                address: '',
                deliveryDate: '',
                amount: '',
                costPerKg: '',
                cost: '',
                comment: '',
                delivered: false
            }
        }
        $('#add-edit-order').modal('show');
    }


    $scope.onSaveOrder = function () {
        $http.post('/order-rest/save-edited-order', $scope._order)
            .then(function onSuccess(response) {
                let obj = response.data;
                if (obj) {
                    $scope.orders = obj;
                    makeOrdersInfo();
                    $('#add-edit-order').modal('hide');
                }
            });
    }

    $scope.onShowDeleteModal = function (id){
        $scope.deleteOrderId = id;
        $('#delete-order').modal('show');
    }

    $scope.onDeleteOrder = function (){
        $http.delete('/order-rest/delete/' + $scope.deleteOrderId)
            .then(function onSuccess(response) {
                let obj = response.data;
                if (obj) {
                    $scope.orders = obj;
                    makeOrdersInfo();
                    $('#delete-order').modal('hide');
                }
            });
    }

    $scope.copyTextField = function (value){

    }

    function makeOrdersInfo() {
        $scope.ordersInfo = {
            weight: $scope.orders.map(el => el.amount).reduce((sum, current) => sum + current, 0),
            cost: $scope.orders.map(el => el.cost).reduce((sum, current) => sum + current, 0),
            delivered: $scope.orders.filter(el => el.delivered).length,
            left: $scope.orders.filter(el => !el.delivered).length,
        };
    }

    $scope.onResetOrderFields = function () {
        $scope._order = {
            id: null,
            clientName: '',
            phoneNumber: '',
            address: '',
            deliveryDate: '',
            amount: '',
            costPerKg: '',
            cost: '',
            comment: '',
            delivered: false
        }
    }

    $scope.calculateCost = function (amount, costPerKg) {
        let result = amount * costPerKg;
        return $scope._order.cost = result.toFixed(2)
    }

    $scope.init();

});