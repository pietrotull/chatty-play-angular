/**
 * Home controllers.
 */
define([], function() {
  'use strict';

  /** Controls the index page */
  var HomeCtrl = function($scope, $rootScope, $location, helper, msgService) {
    $rootScope.pageTitle = 'Welcome';
    $scope.submitMsg = function () {
      msgService.sendMsg($scope.msg);
    };
    $scope.messages = msgService.messages;
    $scope.checkMsgs = function() {
      console.log('Has ' + $scope.messages.length + 'msg(s)');
    };
  };

  HomeCtrl.$inject = ['$scope', '$rootScope', '$location', 'helper', 'msgService'];

  /** Controls the header */
  var HeaderCtrl = function($scope, userService, helper, $location) {
    // Wrap the current user from the service in a watch expression
    $scope.$watch(function() {
      var user = userService.getUser();
      return user;
    }, function(user) {
      $scope.user = user;
    }, true);

    $scope.logout = function() {
      userService.logout();
      $scope.user = undefined;
      $location.path('/');
    };
  };
  HeaderCtrl.$inject = ['$scope', 'userService', 'helper', '$location'];

  /** Controls the footer */
  var FooterCtrl = function(/*$scope*/) {
  };
  //FooterCtrl.$inject = ['$scope'];

  return {
    HeaderCtrl: HeaderCtrl,
    FooterCtrl: FooterCtrl,
    HomeCtrl: HomeCtrl
  };

});
