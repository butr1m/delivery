'use strict';
const app = angular.module('MiniApp', []);
app.controller('clientCtrl', function ($scope, $http) {

    $scope.init = function () {
        getAllClients();
    }

    function getAllClients() {
        $http.get('/clients-rest/find-all')
            .then(function onSuccess(response) {
                let obj = response.data;
                if (obj) {
                    $scope.clients = obj;
                }
            });
    }

    $scope.init();

});
