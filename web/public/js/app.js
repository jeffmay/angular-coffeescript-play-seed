(function() {
  'use strict';

  define("angular", ['webjars!angular.js'], function() {
    return angular;
  });

  require(['angular', './controllers', './directives', './filters', './services'], function(angular, controllers) {
    angular.module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives']).config([
      '$routeProvider', function($routeProvider) {
        $routeProvider.when('/board', {
          templateUrl: 'partials/board.html',
          controller: controllers.Board
        });
        return $routeProvider.otherwise({
          redirectTo: '/board'
        });
      }
    ]);
    return angular.bootstrap(document, ['myApp']);
  });

}).call(this);
