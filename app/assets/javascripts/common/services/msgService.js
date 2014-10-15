/**
 * Created by TGDKEPI1 on 12.10.2014.
 */
define(['angular', './playRoutes'], function (angular) {
  'use strict';

  var mod = angular.module('common.msgService', ['common.playRoutes']);
  mod.factory('msgService', ['$rootScope', '$http', 'playRoutes', function ($rootScope, $http, playRoutes) {
    var messages = [], msgSocket;

    return {
      start: function () {
        var webSocketUrl = playRoutes.controllers.Application.initWebSocket().webSocketUrl();
        msgSocket = new WebSocket(webSocketUrl);
        msgSocket.onopen = function (event) {
          console.log('onopen : ', event);
        };

        msgSocket.onmessage = function(msg) {
          $rootScope.$apply(function() {
            messages.push(msg.data);
          });
        };
      },
      sendMsg: function (msg) {
        msgSocket.send(msg);
      },
      messages: messages
    };
  }]);
});