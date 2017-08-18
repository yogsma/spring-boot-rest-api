var app = angular.module('benefitApp', ['ngRoute','ngResource']);

app.controller('MainCtrl', function($rootScope, $scope, $http, $routeParams,$location,$window) {
	  $scope.name = 'World';
	  $scope.$routeParams = $routeParams;
	  
	  $scope.logout = function() {
          $http.post('logout', {}).then(function(success){
        	  $rootScope.authenticated = false;
              $location.path("/login");
              $window.location.reload();
          },function(error){
        	  console.log("Logout Failed");
              $rootScope.authenticated = false;
        	  alert("Logout Failed")
          });                    
      }
})

app.controller('UserCtrl', function($rootScope,$scope, $http, $routeParams,$location,$window){
	$scope.name = "User";
	$scope.$routeParams = $routeParams;
	
	$scope.logout = function() {
          $http.post('logout', {}).then(function(success){
        	  $rootScope.authenticated = false;
              $location.path("/login");
              $window.location.reload();
          },function(error){
        	  console.log("Logout failed");
              $rootScope.authenticated = false;
        	  alert("Logout Failed");
          });                    
      }
})

app.controller('userController', ['$scope','$http','$location',function($scope, $http, $location) {
  $http.get("https://localhost:8443/benefits/v1/users/").then(function (response){
      $scope.usersData = response.data;
  });
  $scope.editUser = function(userId) {	  
	  $location.path('editUser/' + userId);	  
  };
  $scope.createNewUser = function(){
	  $location.path('createUser/');
  }
  $scope.deleteUser = function(userId){
	  $http.delete("https://localhost:8443/benefits/v1/users/" + userId).then(function(response){
		  alert('User deleted.');
		  $location.path('listUser/');
	  },function(error){
		  alert('Error deleting user '.error);
	  });
  }
}]);

app.controller('singleuserController',function($rootScope, $scope,$http, $routeParams,$location,$window){		
	$http.get("https://localhost:8443/benefits/v1/users/" + $routeParams.userid).then(function(response){
		$scope.user = response.data;
	});
	$scope.updateUser = function(){
		$http.put("https://localhost:8443/benefits/v1/users/", $scope.user).then(function(response){
			$scope.user = response.data;
		});		
	};
	$scope.cancel = function(){
		$location.path('user/');
	};
	$scope.logout = function() {
          $http.post('logout', {}).then(function(success){
        	  $rootScope.authenticated = false;
              $location.path("/login");
              $window.location.reload();
          },function(error){
        	  console.log("Logout failed");
              $rootScope.authenticated = false;
        	  alert("Logout Failed")
          });                    
    }
})


app.controller('editUserCtrl',function($scope,$http, $routeParams,$location){
	$scope.id = $routeParams.userId;
	console.log($routeParams.userId);
	$http.get("https://localhost:8443/benefits/v1/users/" + $scope.id).then(function(response){
		$scope.user = response.data;
	});
	$scope.updateUser = function(){
		$http.put("https://localhost:8443/benefits/v1/users/", $scope.user).then(function(response){
			$scope.user = response.data;
		});		
	};
	$scope.cancel = function(){
		$location.path('listUser/');
	}
});

app.controller('createUserCtrl',function($scope,$http,$location){
	$scope.createNewUser = function(){
		$http.post("https://localhost:8443/benefits/v1/users/", $scope.user).then(function(response){
			$scope.user = response.data;
			$location.path('listUser/');
		});
	};
});

app.controller('companyController', function($scope, $http, $location) {
  $http.get("https://localhost:8443/benefits/v1/companies/").then(function (response){
      $scope.companiesData = response.data;
  });
  $scope.editCompany = function(companyId) {	  
	  $location.path('editCompany/' + companyId);	  
  };
  $scope.createNewCompany = function(){
	  $location.path('createCompany/');
  };
  $scope.deleteCompany = function(companyId){
	  $http.delete("https://localhost:8443/benefits/v1/companies/" + companyId).then(function(response){
		  alert('Company deleted.');
		  $location.path('listCompany/');
	  },function(error){
		  alert('Error deleting company '.error);
	  });
  }
});

app.controller('editCompanyCtrl',function($scope,$http, $routeParams,$location){
	$scope.id = $routeParams.companyId;
	console.log($routeParams.companyId);
	$http.get("https://localhost:8443/benefits/v1/companies/" + $scope.id).then(function(response){
		$scope.company = response.data;
	});
	$scope.updateCompany = function(){
		$http.put("https://localhost:8443/benefits/v1/companies/", $scope.company).then(function(response){
			$scope.company = response.data;
			$location.path('listCompany/');
		});		
	};
	$scope.cancel = function(){
		$location.path('listCompany/');
	}
});

app.controller('createCompanyCtrl',function($scope,$http,$location){
	$scope.createNewCompany = function(){
		$http.post("https://localhost:8443/benefits/v1/companies/",$scope.company).then(function(response){
			$scope.company = response.data;
			$location.path('listCompany/');
		});
	};
});

app.config(function($httpProvider, $routeProvider,$locationProvider){	
//	$httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';
//    $httpProvider.interceptors.push(function() {
//        return {
//            response: function(response) {
//                $httpProvider.defaults.headers.common['X-CSRF-TOKEN'] = response.headers('X-CSRF-TOKEN');
//                return response;
//            }
//        }    
//    });
//	$httpProvider.interceptors.push('CsrfTokenInterceptorService');
	$locationProvider.html5Mode(true);
	$routeProvider.when('/listUser', {templateUrl: 'views/listUser.html', controller: 'userController'});
	$routeProvider.when('/userProfile/:userid', {templateUrl: 		
		'views/userProfile.html', controller: 'singleuserController'});
	$routeProvider.when('/listCompany',{templateUrl: 'views/listCompany.html', controller: 'companyController'});
	$routeProvider
		.when('/editUser/:userId', {
				templateUrl : 'views/editUser.html'
			})
			;	
	$routeProvider
		.when('/editCompany/:companyId', {
			templateUrl : 'views/editCompany.html'
		})
		;
	$routeProvider.when('/createUser',{templateUrl:'views/createUser.html'});
	$routeProvider.when('/createCompany',{templateUrl:'views/createCompany.html'});
	$routeProvider.when('/login',{templateUrl:'login.html'});
});

/* app.factory('CsrfTokenInterceptorService', [function () {
    var token = null;

    return{
        request: function(config){
            if(token){
               config.headers['X-CSRF-TOKEN'] = token;
            }
            return config;
        },
        response: function(response){
            token = response.headers('X-CSRF-TOKEN');
            return response;
        }
    }
}]) */