/**
 * Created by TGDKEPI1 on 12.10.2014.
 */
define(['angular', './playRoutes'], function (angular) {
  'use strict';

  var mod = angular.module('common.msgService', ['common.playRoutes']);
  mod.factory('msgService', ['$rootScope', '$http', 'playRoutes', function ($rootScope, $http, playRoutes) {
    var messages = [];

    return {
      start: function () {
        var webSocketUrl = playRoutes.controllers.Application.initWebSocket().webSocketUrl();
        // console.log('käynnistyy: ', playRoutes.controllers);
        $rootScope.messagingSocket = new WebSocket(webSocketUrl);
        $rootScope.messagingSocket.onopen = function (event) {
          console.log('onopen : ', event);
        };

        $rootScope.messagingSocket.onmessage = function(msg) {
          $rootScope.$apply(function() {
            messages.push(msg.data);
          });

          console.log('received : ', msg);
        };
      },
      sendMsg: function (msg) {
        $rootScope.messagingSocket.send(msg);
      },
      messages: messages
    };
  }]);
});