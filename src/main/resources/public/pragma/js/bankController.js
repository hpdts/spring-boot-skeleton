app.controller("bankController", function($scope, $http) {
    $http.get('http://localhost:8080/banks').
        success(function(data) {
            console.log("data" + JSON.stringify(data));
            $scope.banks = data;
        });
});