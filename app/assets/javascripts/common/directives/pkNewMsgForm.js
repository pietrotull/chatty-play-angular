/**
 * A common directive.
 * It would also be ok to put all directives into one file, or to define one RequireJS module
 * that references them all.
 */
define(['angular'], function(angular) {
  'use strict';

  var mod = angular.module('common.directives.pkNewMsgForm', []);
  mod.directive('pknewmsgform', ['$log', 'msgService', function($log, msgService) {
    return {
      restrict: 'AE',
      templateUrl: '/assets/javascripts/common/directives/pkNewMsgForm.html',
      scope: {},
      controller: function ($scope) {
        $scope.submitMsg = function () {
          var msg = { user: $scope.user, msg: $scope.msg };
          msgService.sendMsg(JSON.stringify(msg));
          $log.info('sent msg: ', msg);
          $scope.msg = '';
        };
      }
    };
  }]);
  return mod;
});
