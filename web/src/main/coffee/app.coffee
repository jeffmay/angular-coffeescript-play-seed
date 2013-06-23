'use strict'

define("angular", ['webjars!angular.js'], -> angular)

require(['angular', './controllers', './directives', './filters', './services'],
  (angular, controllers) ->

    # Declare app level module which depends on filters, and services

    angular
      .module('myApp', ['myApp.filters', 'myApp.services', 'myApp.directives'])
      .config(['$routeProvider', ($routeProvider) ->
        $routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: controllers.MyCtrl1})
        $routeProvider.when('/view2', {templateUrl: 'partials/partial2.html', controller: controllers.MyCtrl2})
        $routeProvider.otherwise {redirectTo: '/view1'}
      ])

    angular.bootstrap(document, ['myApp'])

)