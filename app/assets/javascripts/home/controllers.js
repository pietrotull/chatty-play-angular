/**
 * Home controllers.
 */
define([], function() {
  'use strict';

  /** Controls the index page */
  var HomeCtrl = function($scope, $rootScope, $location, helper, msgService, playRoutes) {
    $rootScope.pageTitle = 'Welcome';
    $scope.messages = msgService.messages;

    $scope.submitMsg = function () {
      var msg = { user: $scope.user, msg: $scope.msg };
      msgService.sendMsg(JSON.stringify(msg));
      $scope.msg = '';
    };

    $scope.cakeTest = function () {
      playRoutes.controllers.Application.cakeTest().get().success(function() {
        console.log('Cake Test Worked');
      }).error(function () {
        console.log('Cake Test Failed');
      });
    };
  };

  HomeCtrl.$inject = ['$scope', '$rootScope', '$location', 'helper', 'msgService', 'playRoutes'];

  /** Controls the footer */
  var FooterCtrl = function(/*$scope*/) {
  };
  //FooterCtrl.$inject = ['$scope'];

  return {
    FooterCtrl: FooterCtrl,
    HomeCtrl: HomeCtrl
  };
});
