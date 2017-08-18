var app = angular.module('benefitApp',['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
	.when('/editUser/:id', {templateUrl:'editUser.html'});
});