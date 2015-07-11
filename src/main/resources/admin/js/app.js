(function(){
  var gem = [
    { name: 'Azurite', price: 2.95 }, 
    { name: 'Azurite1', price: 1.95 },
    { name: 'Azurite2', price: 5.95 }
	];
	
  var app = angular.module('gemStore', []);
  

   app.controller('StoreController', function() {
        this.products = gem;
    });


})();