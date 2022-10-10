'use strict';
const app = angular.module('MiniApp', []);
app.controller('allOrderCtrl', function ($scope, $http) {

    $scope.init = function () {
        $scope.getAllOrders();
    }

    $scope.getAllOrders = function () {
        $http.get('/order-rest/find-all-order')
            .then(function onSuccess(response) {
                let obj = response.data;
                if (obj) {
                    $scope.orders = obj;
                }
            });
    }

    $scope.init();

});
