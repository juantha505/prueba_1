<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Reportes</title>
</head>
<body>
  <div class= "row">
      <div class= "col-md-5 seccion1">
          <form method= "get" action= "Controlador">
                <div class= "card">
                     <div class= "card-body">
                         <div class= "form-group">
                              <label>Seleccione el tipo de reporte</label>          
                         </div>
                         <input type= "hidden" name= "menu" value= "Reportes">
                         <div class= "form group d-flex">
                             <div class= "col- sm-6 d-flex" >
                                 <input type= "submit" name= "accion" value="ReporteUsuarios" class= "btn btn-outline-info">
                                 <input type= "submit" name= "accion" value="ReporteClientes" class= "btn btn-outline-info">
                                 <input type= "submit" name= "accion" value="ReporteVentas" class= "btn btn-outline-info">
                                
                             
                             </div>
                         </div>
                   
                 
                 </div>
              </div>
          
          
          </form>
          </div>
      </div>
      <div class="col-md-8">
     
    
    <table class="table table-primary table-striped">
        
                    
                   
                      <c:if test="${opcion==1}">
                          <thead  class= "thead-dark">
                              <tr>
                                    <th scope="col">Cedula</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Email</th>
                                     <th scope="col">Usuario</th>
                
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="lista" items="${listaUsuarios}">
                                  <tr>
                                       <td>${lista.getCedula_usuario()}</td>
                                       <td>${lista.getNombre_usuario()}</td>
                                       <td>${lista.getEmail_usuario()}</td>
                                       <td>${lista.getUsuario()}</td>
                                  </tr>
                                  </c:forEach>     
                              </tbody>
                    </c:if>  
                    <c:if test= "${opcion==2}">
                         <thead  class= "thead-light">
                              <tr>
                                    <th scope="col">Cedula</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Direccion</th>
                                    <th scope="col">Telefono</th>
                                    <th scope="col">Email</th>
                                    
                                    
                
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="lista" items="${listaClientes}">
                                  <tr>
                                       <td>${lista.getCedula_cliente()}</td>
                                       <td>${lista.getNombre_cliente()}</td>
                                       <td>${lista.getDireccion_cliente()}</td>
                                       <td>${lista.getTelefono_cliente()}</td>
                                       <td>${lista.getEmail_cliente()}</td> 
                                  </tr>
                                  </c:forEach>     
                              </tbody>
                    
                    
                    </c:if>
                    <c:if  test= "${opcion==3 }">
                    
                    
                    </c:if>     
                    </table>
             </div>
             
             
         
      

</body>
</html>