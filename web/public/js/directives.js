(function() {
  'use strict';

  define(['angular'], function(angular) {
    return angular.module('myApp.directives', []).directive('appVersion', [
      'version', function(version) {
        return function(scope, elm, attrs) {
          return elm.text(version);
        };
      }
    ]);
  });

}).call(this);
