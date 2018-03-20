var app = angular.module('app')

app.service('ConfigService', function ($http, $rootScope) {

    this.load = function () {

        if (sessionStorage.getItem('AuthKey') != null) {

            $http.defaults.headers.common.Authorization = sessionStorage.getItem('AuthKey');
            $rootScope.authenticated = true;
        }

    }

});
