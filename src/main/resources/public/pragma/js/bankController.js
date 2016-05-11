app.controller("bankController", function($scope, $http) {
    $http.get('http://localhost:8080/banks').
        success(function(data) {
            console.log("data" + JSON.stringify(data));
            $scope.banks = data;
        });

    $scope.insertbank = function(bank){
        console.log("Bank to Save: " + bank.id + "," + bank.description);
        $http.post('http://localhost:8080/save-banks', bank).success(function(){
            alert("Bank created successfully");
            window.location.reload();
        });
    };

    $scope.deletebank = function(bank) {
        console.log(bank);
        var deleteBankConfirm = confirm('Are you absolutely sure you want to delete bank?');
        if (deleteBankConfirm) {
            var url = 'http://localhost:8080/delete-bank?id=' + bank.id;

            $http.delete(url).then(function (response) {
                console.log('Deletion occurred successfully', response.data);
                alert("Bank deleted successfully");
                window.location.reload();
            }, function (error) {
                console.log('An error occurred deleting', error.data);
            });
        }
    };
});