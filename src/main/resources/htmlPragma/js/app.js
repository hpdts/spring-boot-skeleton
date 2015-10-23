(function(){
  var gem = [
    { name: 'Azurite', price: 2.95 }, 
    { name: 'Azurite1', price: 1.95 },
    { name: 'Azurite2', price: 5.95 }
	];
	
  var app = angular.module('banks', []);
  

   app.controller('BankController', function() {
        this.products = gem;
    });

  app.controller('BankController',[ '$http', function($http){
    var store = this;
    store.products = [];

    $http.get('/products.json').success(function(data){
      store.products = data;
    });
    
  }]);

})();