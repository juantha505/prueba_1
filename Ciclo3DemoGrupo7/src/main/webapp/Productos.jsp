<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="co.edu.unbosque.ciclo3demo.Productos"%>

<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Creacion de producto</title>
</head>
<body>

<div class="row">
   <div class="card col-md-4">
       <div class="card-body">
           <h5 class="card-title">Productos</h5>
           <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los productos</h6>
           <div>
     		 <form class="form-sign" method="get" action="Controlador">
      		      
		        <div class="form-group">
		         <input type="hidden" name="menu" value="Productos">
		         <label>Codigo:</label>
		         <input type="text" name="txtcodigo_producto" class="form-control" value="${productoSeleccionado.getCodigo_producto()}">
		        </div>
		        <div class="form-group">
		         <label>ivacompra:</label>
		         <input type="text" name="txtivacompra" class="form-control" value="${productoSeleccionado.getIvacompra()}">
		        </div>
		        <div class="form-group">
		         <label>nitproveedor:</label>
		         <input type="text" name="txtnitproveedor" class="form-control" value="${productoSeleccionado.getNitproveedor()}">
		        </div>
		        <div class="form-group">
		         <label>nombre:</label>
		         <input type="text" name="txtnombre_producto" class="form-control" value="${productoSeleccionado.getNombre_producto()}">
                </div>
		        <div class="form-group">
		        <label>Precio compra:</label>
		         <input type="text" name="txtprecio_compra" class="form-control" value="${productoSeleccionado.getPrecio_compra()}">
		        </div>
		        <div class="form-group">
		        <label>Precio venta:</label>
		         <input type="text" name="txtprecio_venta" class="form-control" value="${productoSeleccionado.getPrecio_venta()}">
		        </div>
		        
		        <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
		        <input type="submit" class="btn btn-success" name="accion" value="Actualizar">
       	 </form>
    </div>
  </div>
  </div>
 <div class="col-md-8">
     <div class="bg-image" style="background-image: url(imagenes/Usuarios.jpg);height: 500px; /* You must set a specified height */
  background-position: center; /* Center the image */
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: cover; ">
    
    <table class="table table-info table-striped">
        <thead class="thead-dark">
            <tr>
                <th scope="col">codigo</th>
                <th scope="col">ivacompra</th>
                <th scope="col">nitproveedor</th>
                <th scope="col">nombre</th>
                <th scope="col">preciocompra</th>
                <th scope="col">precioventa</th>
                <th scope="col"></th>
           </tr>
        </thead>
        <tbody>
            <% ArrayList<Productos> lista= (ArrayList<Productos>) request.getAttribute("lista");
			for (Productos producto:lista){
			%>
			<tr>
				<td><%=producto.getCodigo_producto()%></td>
				<td><%=producto.getIvacompra()%></td>
				<td><%=producto.getNitproveedor()%></td>
				<td><%=producto.getNombre_producto()%></td>
				<td><%=producto.getPrecio_compra()%></td>
				<td><%=producto.getPrecio_venta()%></td>
				
				<td> 
	               <a class="btn btn-warning" href="Controlador?menu=Productos&accion=Cargar&id=<%=producto.getCodigo_producto()%>">Editar</a>
	               <a class="btn btn-danger" href="Controlador?menu=Productos&accion=Eliminar&id=<%=producto.getCodigo_producto()%>">Eliminar</a>
            	</td>
            </tr>
            <%}%>
        </tbody>
    </table>
   </div> 
</div>
<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>
