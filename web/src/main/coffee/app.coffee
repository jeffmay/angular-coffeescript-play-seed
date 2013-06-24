'use strict'

define("angular", ['webjars!angular.js'], -> angular)

require(['angular', './controllers', './directives', './filters', './services'],
  (angular, controllers) ->

    # Declare app level module which depends on filters, and services

    angular
      .module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives'])
      .config(['$routeProvider', ($routeProvider) ->
        $routeProvider.when('/board', {templateUrl: 'partials/board.html', controller: controllers.Board})
        $routeProvider.otherwise {redirectTo: '/board'}
      ])

    angular.bootstrap(document, ['myApp'])

)