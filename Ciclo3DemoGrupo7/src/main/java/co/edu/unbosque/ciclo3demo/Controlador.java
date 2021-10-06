package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    				
    String menu = request.getParameter("menu");
    String accion = request.getParameter("accion");
            
     switch (menu) {
         case "Principal":
    	  request.getRequestDispatcher("/Principal.jsp").forward(request, response);
    	  break;
         case "Usuarios":
    	  if (accion.equals("Listar")) {
    	     try {
    	        ArrayList<Usuarios> lista = TestJSON.getJSON();
    		 request.setAttribute("lista", lista);
    	     } catch (Exception e) {
    		 e.printStackTrace();
    	     }
    	     
    	  }else if(accion.equals("Agregar")) {
    	     Usuarios usuario = new Usuarios();
    	     usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
    	     usuario.setEmail_usuario(request.getParameter("txtemail"));
    	     usuario.setNombre_usuario(request.getParameter("txtnombre"));
    	     usuario.setUsuario(request.getParameter("txtusuario"));
    	     usuario.setPassword(request.getParameter("txtpassword"));
    	     
    	     PrintWriter write = response.getWriter();
    					
    	     int respuesta=0;
    	      try {
    		   respuesta = TestJSON.postJSON(usuario);
    		   if (respuesta==200) {
    	         request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
                                                                                   response);
    		   } else {
    			   write.println("Error: " +  respuesta);
    			}
    			   write.close();

    	     } catch (Exception e) {
    		 e.printStackTrace();
    	      }
    					
    	  }else if(accion.equals("Actualizar")) {
    		     Usuarios usuario = new Usuarios();
    	         usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
    	         usuario.setEmail_usuario(request.getParameter("txtemail"));
    		     usuario.setNombre_usuario(request.getParameter("txtnombre"));
    		     usuario.setPassword(request.getParameter("txtpassword"));			
    		     usuario.setUsuario(request.getParameter("txtusuario"));
    			 
    	         int respuesta=0;
    			 try {
    			   respuesta = TestJSON.putJSON(usuario,usuario.getCedula_usuario());
    			   PrintWriter write = response.getWriter();
    							
    			   if (respuesta==200) {
    		           request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
    	           } else {
    				write.println("Error: " +  respuesta);
    			   }
    				write.close();
    			   } catch (Exception e) {
    				e.printStackTrace();
    			   }
    		}else if(accion.equals("Cargar")) {
    			Long id= Long.parseLong(request.getParameter("id"));
    			try {
    	                ArrayList<Usuarios> lista = TestJSON.getJSON();
    			   System.out.println("Parametro: " + id);						
    			   for (Usuarios usuarios:lista){
    				if (usuarios.getCedula_usuario()==id) {
    				   request.setAttribute("usuarioSeleccionado", usuarios);
    		           request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);	
    				}
    			   }
    			 } catch (Exception e) {
    		       	e.printStackTrace();
    			 }
    		}else if(accion.equals("Eliminar")) {
    	        	Long id= Long.parseLong(request.getParameter("id"));			
    			int respuesta=0;
    			try {
    			   respuesta = TestJSON.deleteJSON(id);
    			   PrintWriter write = response.getWriter();
    			   if (respuesta==200) {
    		       request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
    			   } else {
    				write.println("Error: " +  respuesta + "has aqui llego mi cdigo");
    			   }
    			      write.close();
    			   } catch (Exception e) {
    				e.printStackTrace();
    			   }	
    		}

    	  request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
    	  break;
    	case "Clientes":
    		if (accion.equals("Listar")) {
       	     try {
       	        ArrayList<Clientes> lista = TestJSONClientes.getJSON();
       		 request.setAttribute("lista", lista);
       	     } catch (Exception e) {
       		 e.printStackTrace();
       	     }
       	  }else if(accion.equals("Agregar")) {
       	     Clientes cliente = new Clientes();
       	     cliente.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
       	     cliente.setNombre_cliente(request.getParameter("txtnombre"));
       	     cliente.setDireccion_cliente(request.getParameter("txtdireccion"));
       	     cliente.setTelefono_cliente(request.getParameter("txttelefono"));
       	     cliente.setEmail_cliente(request.getParameter("txtemail"));
       	     
       	     PrintWriter write = response.getWriter();
       					
       	     int respuesta=0;
       	      try {
       		   respuesta = TestJSONClientes.postJSON(cliente);
       		   if (respuesta==200) {
       	         request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
                                                                                      response);
       		   } else {
       			   write.println("Error: " +  respuesta);
       			}
       			   write.close();

       	     } catch (Exception e) {
       		 e.printStackTrace();
       	      }
       					
       	  }else if(accion.equals("Actualizar")) {
       		 Clientes cliente = new Clientes();
      	     cliente.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
      	     cliente.setNombre_cliente(request.getParameter("txtnombre"));
      	     cliente.setDireccion_cliente(request.getParameter("txtdireccion"));
      	     cliente.setTelefono_cliente(request.getParameter("txttelefono"));
      	     cliente.setEmail_cliente(request.getParameter("txtemail"));
       	         int respuesta=0;
       			 try {
       			   respuesta = TestJSONClientes.putJSON(cliente,cliente.getCedula_cliente());
       			   PrintWriter write = response.getWriter();
       							
       			   if (respuesta==200) {
       		           request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
       	           } else {
       				write.println("Error: " +  respuesta);
       			   }
       				write.close();
       			   } catch (Exception e) {
       				e.printStackTrace();
       			   }
       		}else if(accion.equals("Cargar")) {
       			Long id= Long.parseLong(request.getParameter("id"));
       			try {
       	                ArrayList<Clientes> lista1 = TestJSONClientes.getJSON();
       			   System.out.println("Parametro: " + id);						
       			   for (Clientes clientes:lista1){
       				if (clientes.getCedula_cliente()==id) {
       				   request.setAttribute("clienteSeleccionado", clientes);
       		           request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);	
       				}
       			   }
       			 } catch (Exception e) {
       		       	e.printStackTrace();
       			 }
       		}else if(accion.equals("Eliminar")) {
       	        	Long id= Long.parseLong(request.getParameter("id"));			
       			int respuesta=0;
       			try {
       			   respuesta = TestJSONClientes.deleteJSON(id);
       			   PrintWriter write = response.getWriter();
       			   if (respuesta==200) {
       		       request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
       			   } else {
       				write.println("Error: " +  respuesta + "has aqui llego mi cdigo");
       			   }
       			      write.close();
       			   } catch (Exception e) {
       				e.printStackTrace();
       			   }	
       		}

    		request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
    		break;
    		
    	case "Proveedores":	
        	  if (accion.equals("Listar")) {
        	     try {
        	        ArrayList<Proveedores> lista = TestJSONProveedores.getJSON();
        		 request.setAttribute("lista", lista);
        	     } catch (Exception e) {
        		 e.printStackTrace();
        	     }
        	  }else if(accion.equals("Agregar")) {
        	     Proveedores proveedor = new Proveedores();
        	     proveedor.setNitproveedor(request.getParameter("txtnitproveedor"));
        	     proveedor.setCiudad_proveedor(request.getParameter("txtciudadproveedor"));
        	     proveedor.setDireccion_proveedor(request.getParameter("txtdireccionproveedor"));
        	     proveedor.setNombre_proveedor(request.getParameter("txtnombreproveedor"));
        	     proveedor.setTelefono_proveedor(request.getParameter("txttelefonoproveedor"));
        	     
        	     PrintWriter write = response.getWriter();
        					
        	     int respuesta=0;
        	      try {
        		   respuesta = TestJSONProveedores.postJSON(proveedor);
        		   if (respuesta==200) {
        	         request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
                                                                                       response);
        		   } else {
        			   write.println("Error: " +  respuesta);
        			}
        			   write.close();

        	     } catch (Exception e) {
        		 e.printStackTrace();
        	      }
        					
        	  }else if(accion.equals("Actualizar")) {
        		Proveedores proveedor = new Proveedores();
       	        proveedor.setNitproveedor(request.getParameter("txtnitproveedor"));
       	        proveedor.setCiudad_proveedor(request.getParameter("txtciudadproveedor"));
       	        proveedor.setDireccion_proveedor(request.getParameter("txtdireccionproveedor"));
       	        proveedor.setNombre_proveedor(request.getParameter("txtnombreproveedor"));
       	        proveedor.setTelefono_proveedor(request.getParameter("txttelefonoproveedor"));
        			 
        	         int respuesta=0;
        			 try {
        			   respuesta = TestJSONProveedores.putJSON(proveedor,Long.parseLong(proveedor.getNitproveedor()));
        			   PrintWriter write = response.getWriter();
        							
        			   if (respuesta==200) {
        		           request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
        	           } else {
        				write.println("Error: " +  respuesta);
        			   }
        				write.close();
        			   } catch (Exception e) {
        				e.printStackTrace();
        			   }
        		}else if(accion.equals("Cargar")) {
        			String id= request.getParameter("id");
        			try {
        	                ArrayList<Proveedores> lista1 = TestJSONProveedores.getJSON();
        			   System.out.println("Parametro: " + id);						
        			   for (Proveedores proveedores:lista1){
        				if (proveedores.getNitproveedor().equals(id)) {
        				   request.setAttribute("proveedorSeleccionado", proveedores);
        		           request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);	
        				}
        			   }
        			 } catch (Exception e) {
        		       	e.printStackTrace();
        			 }
        		}else if(accion.equals("Eliminar")) {
        	        	Long id= Long.parseLong(request.getParameter("id"));			
        			int respuesta=0;
        			try {
        			   respuesta = TestJSONProveedores.deleteJSON(id);
        			   PrintWriter write = response.getWriter();
        			   if (respuesta==200) {
        		       request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
        			   } else {
        				write.println("Error: " +  respuesta + "has aqui llego mi cdigo");
        			   }
        			      write.close();
        			   } catch (Exception e) {
        				e.printStackTrace();
        			   }	
        		}
    		request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
    	      break;
    	      
    	case "Productos":
        	  if (accion.equals("Listar")) {
       	     try {
       	        ArrayList<Productos> lista = TestJSON_productos.getJSON();
       		 request.setAttribute("lista", lista);
       	     } catch (Exception e) {
       		 e.printStackTrace();
       	     }
       	  }else if(accion.equals("Agregar")) {
       	     Productos producto = new Productos();
       	     producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo_producto")));
             producto.setIvacompra(Double.parseDouble(request.getParameter("txtivacompra")));
       	     producto.setNitproveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
       	     producto.setNombre_producto(request.getParameter("txtnombre_producto"));
       	     producto.setPrecio_compra(Double.parseDouble(request.getParameter("txtprecio_compra")));
       	     producto.setPrecio_venta(Double.parseDouble(request.getParameter("txtprecio_venta")));
       	     
       	     PrintWriter write = response.getWriter();
       					
       	     int respuesta=0;
       	      try {
       		   respuesta = TestJSON_productos.postJSON(producto);
       		   if (respuesta==200) {
       	         request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
                                                                                      response);
       		   } else {
       			   write.println("Error: " +  respuesta);
       			}
       			   write.close();

       	     } catch (Exception e) {
       		 e.printStackTrace();
       	      }
       					
       	  }else if(accion.equals("Actualizar")) {
        	     Productos producto = new Productos();
        	     producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo_producto")));
        	     producto.setIvacompra(Double.parseDouble(request.getParameter("txtivacompra")));
        	     producto.setNitproveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
        	     producto.setNombre_producto(request.getParameter("txtnombre_producto"));
        	     producto.setPrecio_compra(Double.parseDouble(request.getParameter("txtprecio_compra")));
        	     producto.setPrecio_venta(Double.parseDouble(request.getParameter("txtprecio_venta")));
       			 
       	         int respuesta=0;
       			 try {
       			   respuesta = TestJSON_productos.putJSON(producto,producto.getCodigo_producto());
       			   PrintWriter write = response.getWriter();
       							
       			   if (respuesta==200) {
       		           request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
       	           } else {
       				write.println("Error: " +  respuesta);
       			   }
       				write.close();
       			   } catch (Exception e) {
       				e.printStackTrace();
       			   }
       		}else if(accion.equals("Cargar")) {
       			Long id= Long.parseLong(request.getParameter("id"));
       			try {
       	                ArrayList<Productos> lista1 = TestJSON_productos.getJSON();
       			   System.out.println("Parametro: " + id);						
       			   for (Productos productos:lista1){
       				if (productos.getCodigo_producto()==id) {
       				   request.setAttribute("productoSeleccionado", productos);
       		           request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);	
       				}
       			   }
       			 } catch (Exception e) {
       		       	e.printStackTrace();
       			 }
       		}else if(accion.equals("Eliminar")) {
       	        	Long id= Long.parseLong(request.getParameter("id"));			
       			int respuesta=0;
       			try {
       			   respuesta = TestJSON_productos.deleteJSON(id);
       			   PrintWriter write = response.getWriter();
       			   if (respuesta==200) {
       		       request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
       			   } else {
       				write.println("Error: " +  respuesta + "has aqui llego mi cdigo");
       			   }
       			      write.close();
       			   } catch (Exception e) {
       				e.printStackTrace();
       			   }	
       		}

      		request.getRequestDispatcher("/Productos.jsp").forward(request, response);
      		break;
    	case "Ventas":	
    		request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
    		break;
    		
    	}
        }  
}     
