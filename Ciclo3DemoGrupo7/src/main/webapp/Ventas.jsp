
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Ventas</title>
</head>
<body>
<div class="row">
	<div class="col-md-6 seccion1">
		<form method="get" action="Controlador">
			<div class="card">
				<div class="card-body">
					<div class="form-group">
						<label>Datos Clientes</label>
					</div>
					<input type="hidden" name="menu" value="Ventas">
					<input type="hidden" name="UsuarioActivo" value="${usuarioSeleccionado.getCedula_usuario()}">
					<div class="form-group d-flex">
						<div class="col-sm-6 d-flex">
							<input type="number" name="cedulacliente" class="form-control" placeholder="cedula cliente" value="${clienteSeleccionado.getCedula_cliente()}">
							<input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
						</div>
					</div>
					<div class="col-sm-6">
						<input type="text" name="nombrecliente" class="form-control" placeholder="Nombre cliente" value="${clienteSeleccionado.getNombre_cliente()}">
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-body">
					<div class="form-group">
					<label>Datos Productos</label>
					</div>
						<div class="form-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="number" name="codigoproducto" class="form-control" placeholder="Codigo producto" value="${productoSeleccionado.getCodigo_producto()}">
								<input type="submit" name="accion" value="BuscarProductos" class="btn btn-outline-info">
							</div>
							<div class="col-sm-6">
								<input type="text" name="nombreproducto" class="form-control" placeholder="Nombre producto" value="${productoSeleccionado.getNombre_producto()}">
							</div>				
						</div>
					<div class="form-group d-flex">
						<div class="col-sm-6 d-flex">
							<input type="text" name="precioproducto" class="form-control" placeholder="$ 0000.00" value="${productoSeleccionado.getPrecio_venta()}">
						</div>
						<div class="col-sm-3">
							<input type="number" name="cantidadproducto" class="form-control" placeholder="Cantidad">
						</div>
						<div class="col-sm-3">
							<input type="text" name="ivaproducto" class="form-control" placeholder="Valor iva" value="${productoSeleccionado.getIvacompra()}">
						</div>
						
								
					</div>
					<div class="form-group d-flex">
							<input type="submit" name="accion" value="AgregarProducto" class="btn btn-outline-primary">
						</div>					
				</div>
			</div>
		</form>
	</div>
	
	<div class="col-md-6 seccion2">
		<div class="card">
			<div class="card-header">
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">Numero de Factura</label>
					<input class="form-control col-md-4" type="text" name="numerofactura" value="">
				</div>
			</div>
			<div class="card-body">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>#</th>
							<th>Codigo</th>
							<th>Producto</th>
							<th>Precio</th>
							<th>Cantidad</th>
							<th>Iva</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="card-footer d-flex">
				<div class="col-md-4">
					<label>SubTotal</label><br>
					<label>Iva</label><br>
					<label>Total a Pagar</label>
				</div>
				<div class="col-md-4">
					<input type="text" name="txtsubtotal" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="">
					<input type="text" name="txttotaliva" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="">
					<input type="text" name="txttotalapagar" class="form-control" placeholder="$ 00.000.00" disabled="disabled" value="">
				</div>
			</div>
		</div>
		<div class="card-footer">
			<div class="col-md-8">
				<a class="btn btn-success" onclick="print()" href="Controlador?menu=Ventas&accion=GenerarVenta">Generar Venta</a>
				<a class="btn btn-danger" href="Controlador?menu=Ventas&accion=NuevaVenta">Nueva Venta</a>
			</div>
		</div>
	</div>	
</div>



</body>
</html>