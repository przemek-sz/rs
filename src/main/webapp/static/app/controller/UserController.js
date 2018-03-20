var app = angular.module('app')

app.controller('UserController',function ($http) {

    var vm=this;


    ///////////////////////////////////////////////////////////////////
    vm.addUser=function (user) {

        $http({
            method:"POST",
            url:'/api/user',
            data:user
        }).then(function succes() {
           vm.user=null;
        },function error() {

        });

    };
    //////////////////////////////////////////////////////////////////////
    vm.removeUser=function (userName) {
      console.log(userName);
        $http({
            method:'DELETE',
            url:'/api/user/'+userName
        }).then(function succes(response) {
            getUsersList();

        },function error(response) {

        });

    };
    //====================================================================
    vm.login=function (user) {
        console.log(user);
    }

});
