/**
 */
define(['angular'], function (angular) {
  'use strict';

  var mod = angular.module('common.directives.pkheader', []);
  mod.directive('pkheader', ['$log', 'userService', '$location', function ($log, userService, $location) {
    return {
      restrict: 'AE',
      replace: true,
      templateUrl: '/assets/javascripts/common/directives/pkHeader.html',
      link: function ($scope/*scope, el, attrs*/) {

        // Wrap the current user from the service in a watch expression
        $scope.$watch(function () {
          var user = userService.getUser();
          return user;
        }, function (user) {
          $scope.user = user;
        }, true);

        $scope.logout = function () {
          userService.logout();
          $scope.user = undefined;
          $log.info('Logged out');
          $location.path('/');
        };
      }
    };
  }]);
  return mod;
});
