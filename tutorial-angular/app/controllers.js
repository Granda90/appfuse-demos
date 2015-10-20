var unaControllers = angular.module('unaControllers', [ 'mgcrea.ngStrap' ]);

unaControllers.controller('loginController', [ '$scope', '$location',
		'StorageService', function($scope, $location, StorageService) {
			$scope.data = {};

			$scope.checkTheUser = function(myForm) {
				console.log("--> Submitting form");
				if (myForm.password == "1234") {
					console.log("Valid User");

					// This method save the information in the local storage
					StorageService.save('myDataObject', myForm);

					$location.path('/test'); // Redirect to the another page
				}
			}

		} ]);

unaControllers.controller('testController', [ '$scope', 'StorageService',
		function($scope, StorageService) {
			$scope.data = {};

			// This method save the information in the local storage
			$scope.data.myDataObject = StorageService.get('myDataObject');

		} ]);

unaControllers.controller('studentsController', [ '$scope', 'UNAService',
		function($scope, UNAService) {
			$scope.data = {};

			UNAService.getAllStudents(function(error, data) {
				if (!error) {
					$scope.data.students = data;
				}
			});

		} ]);

unaControllers.controller('searchStudentsController', [ '$scope', 'UNAService',
		function($scope, UNAService) {

			$scope.search = function(student) {
				$scope.data = {};

				UNAService.getStudents(student.name, function(error, data) {
					if (!error) {
						$scope.data.students = data;
					}
				});
			};
		} ]);

unaControllers.controller('personController', [ '$scope', 'UNAService',
		function($scope, UNAService) {
			$scope.data = {};

			UNAService.getAllPersons(function(error, data) {
				if (!error) {
					$scope.data.persons = data;
				}
			});

		} ]);
