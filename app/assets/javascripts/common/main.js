/**
 * Common functionality.
 */
define(['angular', './services/helper', './services/playRoutes',  './services/msgService', './filters', './directives/example'],
    function(angular) {
  'use strict';

  return angular.module('yourprefix.common', ['common.helper', 'common.playRoutes', 'common.msgService', 'common.filters',
    'common.directives.example']);
});
