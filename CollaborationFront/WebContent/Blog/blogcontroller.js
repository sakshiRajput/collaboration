/**
 * BLOG CONTROLLER
 */
app.controller('BlogController',function($scope,BlogService,$location){
	$scope.postblog=function()
	{
		console.log("blog data is" +$scope.blog)
		BlogService.postblog($scope.blog).then(function(response){
			$location.path('/success')
		},function(response)
		{
			
			$location.path('/addblog')
		}
		)
	}
	
})