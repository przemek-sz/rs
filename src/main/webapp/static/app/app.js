var app = angular.module('app', ['ngRoute']);

//=============================================================================
app.run(function (ConfigService) {

    ConfigService.load();

});
//=============================================================================
app.config(['$routeProvider',function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'static/partials/mainpage.html'
        })
        .when('/login', {
            templateUrl: 'static/partials/loginpage.html',
            controller:'AuthenticationController',
            controllerAs:'authController'
        })
        .when('/signup', {
            templateUrl: 'static/partials/signup.html'
        })
        .when('/logout', {
            controller:'AuthenticationController',
            controllerAs:'authController'
        }).when('/rssdfeed',{
            templateUrl: 'static/partials/rssfeed.html'

        }).when('/admin',{
            templateUrl:'static/partials/admin.html',
            controller:'AdminController',
            controllerAs:'adminController'
        }).when('/add',{
            templateUrl:'static/partials/addChannel.html'
    });

}]);
//=============================================================================
app.config(['$httpProvider',function ($httpProvider) {

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}]);
