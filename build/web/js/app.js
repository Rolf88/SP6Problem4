var carApp = angular.module('DemoApp', [])
.controller('CarController', ['$http', function ($http) {
        var self = this;
        self.cars = [];
        $http.get('api/car/complete').then(function (response) {
            self.cars = response.data;
        }, function(errResponse){
            console.error('Error while fetching cars');
        });
    }]);