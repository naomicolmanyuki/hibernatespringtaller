<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="regristroProducto">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro Producto</title>
<script type="text/javascript" src="/hibernatespringtaller/resources/angular/angular.js"></script>

<!--Import Google Icon Font-->
<link href="/hibernatespringtaller/resources/materialize/iconos/index.css" rel="stylesheet">

<link type="text/css" rel="stylesheet" 
href="/hibernatespringtaller/resources/materialize/css/materialize.min.css"
media="screen,projection"/>

<script type="text/javascript">
 angular.module("registroProducto",[]);
 
 angular.module("registroProducto").controller("productoController",function($scope,$http){
	 
	 $scope.app="Registro de Producto";
	 
	 //funcion para registrar pedido via post
	 $scope.registrarProducto=function(producto){
		 
		 
		 $http.post("http://localhost:8080/hibernatespringtaller/producto",producto).success(function(){
			$scope.producto=undefined; 
		 });
		 
	 };
	 
	 
 });

</script>

</head>

<body ng-controller="productoController">

<h4 ng-bind="app"></h4>

{{producto}}

<!-- Materialize divine la pagina en 12 partes iguales -->
<div class="row">

<div class="col s2"></div>

<form class="col s8">

<div class="row">

<div class="input/field col s6">
<i class="material-icons prefix">shopping_basket</i>
<input id="cantidad" type="number" class="validate" ng-model="producto.cantidad">
<label for="cantidad">Cantidad</label>
</div>

<div class="input/field col s6">
<i class="material-icons prefix">shopping_basket</i>
<input id="descripcion" type="text" class="validate" ng-model="producto.descripcion">
<label for="descripcion">Descripcion</label>
</div>

<div class="input/field col s6">
<i class="material-icons prefix">shopping_basket</i>
<input id="fechaVencimiento" type="text" class="validate" ng-model="producto.fechaVencimiento">
<label for="fechaVencimiento">Vencimiento</label>
</div>

<div class="input/field col s6">
<i class="material-icons prefix">shopping_basket</i>
<input id="precio" type="number" class="validate" ng-model="producto.precio">
<label for="precio">Precio</label>
</div>

<button class="btn" ng-click="producto">Registrar</button>

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
<td>Cantidad</td>
<td>Descripcion</td>
<td>Fecha Vencimiento</td>
<td>Precio</td>
</tr>

</thead>
<tbody>
<tr ng-repeat="producto in producto">
<td>{{producto.cantidad}}</td>
<td>{{producto.descripcion}}</td>
<td>{{producto.fechaVencimiento}}</td>
<td>{{producto.precio}}</td>
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