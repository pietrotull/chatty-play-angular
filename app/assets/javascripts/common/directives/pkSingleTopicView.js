/**
 * A common directive.
 * It would also be ok to put all directives into one file, or to define one RequireJS module
 * that references them all.
 */
define(['angular'], function(angular) {
  'use strict';

  var mod = angular.module('common.directives.pksingletopicview', []);
  mod.directive('pksingletopicview', [function() {
    return {
      restrict: 'AE',
      templateUrl: '/assets/javascripts/common/directives/pkSingleTopicView.html',
      controller: ['$scope', '$log',function ($scope, $log) {
        $log.debug('loaded topic view', $scope);
      }]
    };
  }]);
  return mod;
});
