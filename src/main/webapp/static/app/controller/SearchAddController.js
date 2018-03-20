var app=angular.module('app')

app.controller('SearchAddController',function ($http) {

    var vm=this;


    vm.search=function (url) {

        $http({
            method:'POST',
            url:'/api/channel/search',
            data:url
        }).then(function succes(response){
            vm.channels=response.data;
        },function error() {

        });
    };

    this.add=function (url) {

        $http({
            method:'PUT',
            url:'/api/channel/add',
            data:url
        }).then(function succes() {

        },function error() {

        });
    };

});