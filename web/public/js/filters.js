(function() {
  'use strict';

  define(['angular'], function(angular) {
    return angular.module('myApp.filters', []).filter('interpolate', [
      'version', function(version) {
        return function(text) {
          return String(text).replace(/\%VERSION\%/mg, version);
        };
      }
    ]);
  });

}).call(this);
