'use strict';

define(['angular'], (angular) ->

  # Filters

  angular
    .module('myApp.filters', [])
    .filter('interpolate', [
      'version',
      (version) ->
        (text) -> String(text).replace(/\%VERSION\%/mg, version)
    ])

)