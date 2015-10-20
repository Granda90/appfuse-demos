var dicApp = angular.module('dicApp', [
  'ngRoute',
  'unaControllers',
  'unaServices'
]);

dicApp.config(['$routeProvider', '$httpProvider', 
  function ($routeProvider, $httpProvider) {
	$httpProvider.defaults.useXDomain = true;  
	$routeProvider.
        when('/login', {
          templateUrl: 'app/views/login.html',
          controller: 'loginController'
        }).
        when('/test', {
          templateUrl: 'app/views/testPage.html',
          controller: 'testController'
        }).
        when('/students', {
            templateUrl: 'app/views/students.html',
            controller: 'studentsController'
        }).
        when('/search', {
          templateUrl: 'app/views/search.html',
          controller: 'searchStudentsController'
        }).
        when('/person', {
            templateUrl: 'app/views/person.html',
            controller: 'personController'
          }).        
        otherwise({
            redirectTo: '/login'
        });
  }]);