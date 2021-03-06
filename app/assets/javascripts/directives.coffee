'use strict'

define(['angular'], (angular) ->

  # Directives

  angular
    .module('myApp.directives', [])
    .directive('appVersion', [
      'version',
      (version) -> (scope, elm, attrs) -> elm.text(version)
    ])

)