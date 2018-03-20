var app = angular.module('app')

app.controller('AdminController',function($http){

    var vm=this;

    getUsersList();
    function getUsersList() {

        $http({
            method:'GET',
            url:'/api/admin'
        }).then(function succes(response) {
            vm.users=response.data;
        },function error(response) {

        });
    };

    vm.removeUser=function (userName) {
        console.log(userName);
        $http({
            method:'DELETE',
            url:'/api/admin/'+userName
        }).then(function succes(response) {
            getUsersList();

        },function error(response) {

        });

    };


});