'use strict';

/* Controllers */

var plantControllers = angular.module('plantControllers', []);

plantControllers.controller('HomeCtrl', ['$scope', 'Plant',
   function($scope, Plant) {
    $scope.news = Plant.query({requestId: 'news'});
    $scope.companyIntroduce = Plant.get({requestId: 'companyIntroduce'});
    $scope.contactUs = Plant.get({requestId: 'contactUs'});
   }]);

plantControllers.controller('ContactUsCtrl', ['$scope', 'Plant',
   function($scope,Plant) {
	$scope.news = Plant.query({requestId: 'news'});
	$scope.contactUs = Plant.get({requestId: 'contactUs'});
   }]);

plantControllers.controller('LeaveWordsCtrl', ['$scope', 'Plant',
   function($scope,Plant) {
    $scope.news = Plant.query({requestId: 'news'});
    $scope.contactUs = Plant.get({requestId: 'contactUs'});
   }]);

plantControllers.controller('NewsCtrl', ['$scope', 'Plant',
   function($scope,Plant) {
    $scope.news = Plant.query({requestId: 'news'});
    $scope.contactUs = Plant.get({requestId: 'contactUs'});
   }]);

/*plantControllers.controller('DisplayCtrl', ['$scope', 'Plant',
   function($scope,Plant) {
    $scope.news = Plant.query({requestId: 'news'});
    $scope.contactUs = Plant.get({requestId: 'contactUs'});
   }]);*/

/*plantControllers.controller('smallNavigation', ['$scope',
   function($scope) {
	
	 $scope.home = function(){
		 $("#Home").click();
     }
	 
	 $scope.introduce = function(){
		 $("#Introduce").click();
     }
	 
	 $scope.news = function(){
		 $("#News").click();
     }
	 
	 $scope.display = function(){
		 $("#Display").click();
     }
	 
	 $scope.words = function(){
		 $("#Words").click();
     }
	 
	 $scope.contact = function(){
		 $("#Contact").click();
     }
    
   }]);*/