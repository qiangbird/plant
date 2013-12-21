'use strict';

/* Services */

var plantServices = angular.module('plantServices', ['ngResource']);

plantServices.factory('Plant', ['$resource',
  function($resource){
    return $resource('DB/:requestId.json');
  }]);

/* factory function safeApply
*
* @description If you find yourself triggering the '$apply already in progress' error while developing with Angular.JS
* (for me I find I hit most often when integrating third party plugins that trigger a lot of DOM events),
* you can use a 'safeApply' method that checks the current phase before executing your function.
*
* @param scope, the action scope, mostly is the topmost controller
* @param fn, the function which you want to apply into scope
* @see  https://coderwall.com/p/ngisma
*/
/*plantServices.factory('safeApply', function($rootScope) {
   return function(scope, fn) {
       var phase = scope.$root.$$phase;
       if (phase == '$apply' || phase == '$digest') {
           if (fn && ( typeof (fn) === 'function')) {
               fn();
           }
       } else {
           scope.$apply(fn);
       }
   }
});*/