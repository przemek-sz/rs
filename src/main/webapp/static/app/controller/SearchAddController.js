var app=angular.module('app')

app.controller('SearchAddController',function ($http) {

    var vm=this;



        getAll();


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

    vm.add=function (url) {

        $http({
            method:'POST',
            url:'/api/channel/add',
            data:url
        }).then(function succes() {

        },function error() {

        });
    };


    function getAll() {

        $http({
            method:'GET',
            url:'api/channel/getall'
        }).then(function succes(response) {
            vm.userChannels=response.data;
        })

    }



});