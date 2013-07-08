(function() {
  'use strict';

  define(['angular'], function(angular) {
    return angular.module('myApp.services', []).value('version', '0.1');
  });

}).call(this);
