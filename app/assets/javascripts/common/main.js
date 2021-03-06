/**
 * Common functionality.
 */
define(['angular', './services/helper', './services/playRoutes',  './services/msgService', './filters', './directives/pkHeader', './directives/pkSingleTopicView', './directives/pkNewMsgForm'],
    function(angular) {
  'use strict';

  return angular.module('yourprefix.common', ['common.helper', 'common.playRoutes', 'common.msgService', 'common.filters',
    'common.directives.pkheader', 'common.directives.pksingletopicview', 'common.directives.pkNewMsgForm']);
});
