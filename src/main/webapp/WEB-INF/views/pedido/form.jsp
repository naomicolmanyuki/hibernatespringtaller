<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroPedido">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Pedido</title>

<script type="text/javascript" src="/hibernatespringtaller/resources/angular/angular.js"></script>

<!--Import Google Icon Font-->
<link href="/hibernatespringtaller/resources/materialize/iconos/index.css" rel="stylesheet">

<link type="text/css" rel="stylesheet" 
href="/hibernatespringtaller/resources/materialize/css/materialize.min.css"
media="screen,projection"/>


<script type="text/javascript">
 angular.module("registroPedido",[]);
 
 angular.module("registroPedido").controller("pedidoController",function($scope,$http){
	 
	 $scope.app="Registro de Pedido";
	 
	 //funcion para registrar pedido via post
	 $scope.registrarPedido=function(pedido){
		 
		 
		 $http.post("http://localhost:8080/hibernatespringtaller/pedido",pedido).success(function(){
			$scope.pedido=undefined; 
		 });
		 
	 };
	 
	 
 });


</script>

</head>

<body ng-controller="pedidoController">

<h4 ng-bind="app"></h4>

{{pedido}}

<!-- Materialize divine la pagina en 12 partes iguales -->
<div class="row">

<div class="col s2"></div>

<form class="col s8">

<div class="row">

<div class="input/field col s6">
<i class="material-icons prefix">work</i>
<input id="total" type="number" class="validate" ng-model="pedido.total">
<label for="total">Total</label>
</div>

<div class="input/field col s6">
<i class="material-icons prefix">work</i>
<input id="fechaToma" type="text" class="validate" ng-model="pedido.fechaToma">
<label for="fechaToma">Fecha Toma</label>
</div>

<button class="btn" ng-click="registrarPedido(pedido)">Registrar</button>

</div>
</form>

<div class="col s2"></div>
</div>

<div>

<div class="row"></div>

<div class="col 12">
<table>

<thead>
<tr>
<td>Total</td>
<td>Fecha Toma</td>
<td>Fecha Entrega</td>
<td>Editar</td>
</tr>

</thead>
<tbody>
<tr ng-repeat="pedido in pedidos">
<td>{{pedido.total}}</td>
<td>{{pedido.fechaToma}}</td>
<td>{{pedido.fechaEntrega}}</td>
<td>Editar</td>
</tr>



</tbody>


</table>

</div>


</div>



<script type="text/javascript" 
src="/hibernatespringtaller/resources/jquery.js"></script>

<script type="text/javascript" 
src="/hibernatespringtaller/resources/materialize/js/materialize.min.js"></script>


</body>
</html>