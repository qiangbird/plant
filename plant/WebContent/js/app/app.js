'use strict';

/* App Module */
/*angular.module('plantApp', ['ngRoute', 'ngAnimate','plantControllers','plantServices'],
		  function($routeProvider, $locationProvider) {
			 $routeProvider.when('/home', {
		      templateUrl: 'home.html',
		      controller: 'HomeCtrl'
		    });
		    $routeProvider.when('/contactUs', {
		      templateUrl: 'contactUs.html',
		      controller: 'ContactUsCtrl'
		    }).otherwise({
		        redirectTo: '/home'
		      });;
		    
		    // configure html5 to get links working on jsfiddle
		    $locationProvider.html5Mode(true);
});*/
		    
var plantApp = angular.module('plantApp', [
  'ngRoute',
  'ngTouch',
  
  'plantControllers',
 /*  'plantFilters',*/
  'plantServices'
/*  'plantDirectives'*/
]);

plantApp.config(['$routeProvider', 
  function($routeProvider) {
    $routeProvider.
      when('/home', {
        templateUrl: 'home.html',
        controller: 'HomeCtrl'
      }).
      when('/contactUs', {
          templateUrl: 'contactUs.html',
          controller: 'ContactUsCtrl'
        }).
      when('/leavewords', {
          templateUrl: 'leaveWords.html',
          controller: 'LeaveWordsCtrl'
        }).
      when('/display', {
          templateUrl: 'display.html'
//          controller: 'DisplayCtrl'
        }).
      when('/news', {
          templateUrl: 'news.html',
          controller: 'NewsCtrl'
        }).
      otherwise({
        redirectTo: '/home'
      });

    
    // configure html5 to get links working on jsfiddle
//    $locationProvider.html5Mode(true);
  }]);

