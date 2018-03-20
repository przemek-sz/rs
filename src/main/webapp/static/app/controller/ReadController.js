var app = angular.module('app')

app.controller('ReadController',function ($http,$location) {

    var vm=this;



    vm.readFromUrl=function (url) {

        $http({
            method:'POST',
            url:'/api/read',
            data:url
        }).then( function succes(response){
                console.log("czytanie url");
                vm.feed=response.data;
            },
            function error(){

          }
        );

    }

    getData=function (){

        $http({
            method:'GET',
            url:''
        }).then( function succes(){

            },
            function error(){

            }

        );
    }












})