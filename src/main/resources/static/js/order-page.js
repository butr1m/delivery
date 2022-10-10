'use strict';
const app = angular.module('MiniApp', []);
app.controller('orderController', function ($scope, $http) {

    $scope.phoneNumberPattern = '\\+?\\d{3}-\\d{2}-\\d{7}';

    $scope.init = function () {
    }

    $scope.openOrderModal = function (order) {
        if (!order) {
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
        } else {
            $scope._order = angular.copy(order);
        }
        $('#add-edit-order').modal('show');
    }

    $scope.calculateCost = function (amount, costPerKg) {
        let result = amount * costPerKg;
        return $scope._order.cost = result.toFixed(2)
    }

    $scope.onSaveOrder = function () {
        $http.post('/order-rest/save-order', $scope._order)
            .then(function onSuccess(response) {
                let obj = response.data;
                if (obj) {
                    $('#add-edit-order').modal('hide');
                }
            });
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

    $scope.init();

});
