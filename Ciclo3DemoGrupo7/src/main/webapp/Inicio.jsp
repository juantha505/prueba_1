<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body >

<div class="bg-image" style="background-image: url(imagenes/Fondo_Login2.jpg);height: 600px; /* You must set a specified height */
  background-position: center; /* Center the image */
  background-repeat: no-repeat; /* Do not repeat the image */
  background-size: cover; ">
     
   <div class= "container mt-4 col-lg-4">
   
      <div class="card col-sm-10">
         <div class= "card-body">
            <form class="form-sign" method= "get" action="./DemoServlet" >
                      <div class= "form-group text-center" >
                       <h1 align="center">DIGITAL TIC </h1>
                      <h3> Login  </h3>
                      <img src="imagenes/login.png" width="10%" alt="10">
                      <label>Validacion de Usuario</label>
                      
                      <div class="form-floating mb-3">
                          <input type="text" name="txtusuario" class="form-control" id="floatingInput" placeholder="name@example.com">
                          <label for="floatingInput">Usuario</label>
                      </div>
                      <div class="form-floating">
                          <input type="password" name="txtpassword" class="form-control" id="floatingPassword" placeholder="Password">
                          <label for="floatingPassword">Password</label>
                      </div>
                      
                      <div class="d-grid gap-2">
                          <input type="submit" name="accion" value="Ingresar" class="btn btn-primary">
                      </div>
                      
                </div>      
            </form>    
         </div>
      </div>
   </div>
   
</div>

</body>

</html>
