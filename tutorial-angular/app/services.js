var unaServices = angular.module('unaServices', [ 'ngResource' ]);

// http://docs.mongolab.com/restapi/#list-collections

unaServices
		.factory(
				'UNAService',
				function($http) {
					var serviceURL = 'https://api.mongolab.com/api/1/databases/avantica-test/collections/students?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb';
					var serviceAppFuseURL = 'http://localhost:8080/services/api/people';
					return {
						getAllStudents : function(callback) {
							$http.get(serviceURL).success(function(data) {
								callback(null, data);
							}).error(function(e) {
								callback(e);
							});
						},
						getStudents : function(query, callback) {
							var query = "{'name':'" + query + "'}"
							$http.get(serviceURL, {
								params : {
									q : query
								}
							}).success(function(data) {
								callback(null, data);
							}).error(function(e) {
								callback(e);
							});
						},
						getAllPersons : function(callback) {
							$http.get(serviceAppFuseURL).success(function(data) {
								callback(null, data);
							}).error(function(e) {
								callback(e);
							});
						}
					}
				});

unaServices.factory('StorageService', function StorageService($window) {
	return {
		get : function(key) {
			var data = angular.fromJson($window.sessionStorage.getItem(key));

			return data;
		},

		save : function(key, dataToSave) {
			var dataToSaveInJson = angular.toJson(dataToSave);

			return $window.sessionStorage.setItem(key, dataToSaveInJson);
		},

		remove : function(key) {
			return $window.sessionStorage.removeItem(key);
		},

		clear : function() {
			$window.sessionStorage.clear();
		}
	}
});