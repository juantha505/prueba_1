package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//**** Variable generales dentro de la clase Controlador ******
	        double subtotal=0, totalpagar=0;
			double  precio=0, valor_iva=0, iva=0, subtotaliva=0, acusubtotal=0;
			long numfac=0, codProducto=0;
			int cantidad=0, item=0;
			
			
			String descripcion, cedulaCliente;
			
			List<Detalle_Ventas> listaVentas = new ArrayList<>();
			Clientes clientes= new Clientes();
			Usuarios usuarios = new Usuarios();
			Detalle_Ventas detalle_venta = new Detalle_Ventas();
			//*************************
	        
       
        public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    	//***** Metodos lpcales para buscar Clientes y Productos ****
    	public void buscarProducto(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    			ArrayList<Productos> listap=TestJSON_productos.getJSON();
    			for(Productos productos:listap) {
    				if(productos.getCodigo_producto()==id) {
    					request.setAttribute("productoSeleccionado", productos);
    				}  
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	public void buscarCliente(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    			ArrayList<Clientes> listac=TestJSONClientes.getJSON();
    			for(Clientes clientes:listac) {
    				if(clientes.getCedula_cliente()==id)  {
    					request.setAttribute("clienteSeleccionado", clientes);
    				}
    				 
    			}
    	
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	public void mostrarFactura (String numFact, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        	if(numFact == null) {
        		numfac = Integer.parseInt(numFact)+1;
        		
        	}else {
        		numfac = Integer.parseInt(numFact)+1;
        	}
        	request.setAttribute("numerofactura", numfac);
        }
         
        // grabar en la table de detalles ventas 
        public void grabarDetalle_ventas (Long numFact, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        	
        	for (int i=0; i< listaVentas.size(); i++) {
        		detalle_venta = new Detalle_Ventas ();
        		detalle_venta.setCodigo_detalle_venta(String.valueOf(i=1));
        		detalle_venta.setCodigo_venta (numFact);
        		detalle_venta.setCodigo_producto (listaVentas.get(i).getCodigo_producto ());
        		detalle_venta.setCantidad_producto (listaVentas.get(i).getCantidad_producto());
        		detalle_venta.setValor_venta(listaVentas.get(i).getValor_venta());
        		detalle_venta.setValor_total (listaVentas.get(i).getValor_total ());
        		detalle_venta.setValor_iva(listaVentas.get(i).getValor_iva ());
        		
        		int respuesta =0;
        		try {
        			//respuesta= TestJSONVentas.postJSON(listaVentas);
        			PrintWriter write = response.getWriter ();
        			if (respuesta== 200) {
        				System.out.println("Registros grabados en Detalle Venta");
        				
        			}else {
        				write.println("Error detalle venta" + respuesta);
        				
        			}write.close();
	
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        		
        			
        		}
        		
        		
        	}
    	
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        		// TODO Auto-generated method stub


   
        	
        	
    				
    String menu = request.getParameter("menu");
    String accion = request.getParameter("accion");
    //Long cedula_usuario_activo =Long.parseLong(request.getParameter("UsuarioActivo"));
    //usuarios.setCedula_usuario (cedula_usuario_activo);
    request.setAttribute("usuarioSeleccionado", usuarios);
    
    //**** Variable para recibir la cedula del usuario y poderla utilizar al guardar la venta *****
   
   
    request.setAttribute("usuarioSeleccionado", usuarios);
    //*************************************      
            
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
        		  usuario.setNombre_usuario(request.getParameter("txtnombre"));
        		  usuario.setEmail_usuario(request.getParameter("txtemail"));	  
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
              	  usuario.setNombre_usuario(request.getParameter("txtnombre"));
       		      usuario.setEmail_usuario(request.getParameter("txtemail"));
       	          usuario.setUsuario(request.getParameter("txtusuario"));
       	          usuario.setPassword(request.getParameter("txtpassword"));
       	     
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
        	                ArrayList<Usuarios> lista1 = TestJSON.getJSON();
        			   System.out.println("Parametro: " + id);						
        			   for (Usuarios clientes:lista1){
        				if (clientes.getCedula_usuario()==id) {
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
        				write.println("Error: " +  respuesta + "error en el codigo");
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
    		// enviaremos la cedula del usuario activo al formulario de ventas.jsp
    		request.setAttribute("usuarioSeleccionado", usuarios);
    		request.setAttribute("numerofactura", numfac);
    		
    		if (accion.equals("BuscarCliente")) {
    			Long id=Long.parseLong(request.getParameter("cedulacliente"));
    			this.buscarCliente(id, request, response);
    			
    		}else if (accion.equals("BuscarProductos")) {
    			Long id=Long.parseLong(request.getParameter("cedulacliente"));
    			this.buscarCliente(id, request, response);
    			
    			long cod=Long.parseLong(request.getParameter("codigoproducto"));
    			this.buscarProducto(cod, request, response);
    			//String id1=request.getParameter("cedulacliente");
    			//this.buscarCliente(Long.parseLong(id1), request, response);
    			
    		}else if (accion.equals("AgregarProducto")) {
    			Long id=Long.parseLong(request.getParameter("cedulacliente"));
    			this.buscarCliente(id, request, response);
    		
    			
    			
    			detalle_venta = new Detalle_Ventas();
    			item++;
    			totalpagar = 0;
    			acusubtotal = 0;
    			subtotaliva  = 0;
    			codProducto=Long.parseLong(request.getParameter("codigoproducto"));
    			descripcion=request.getParameter("nombreproducto");
    			precio= Double.parseDouble(request.getParameter("precioproducto"));
    			cantidad=Integer.parseInt(request.getParameter("cantidadproducto"));
    			valor_iva =Double.parseDouble(request.getParameter("ivaproducto"));
    			
    			subtotal = (precio*cantidad);
    			iva = (valor_iva*subtotal/100);
    			
    			detalle_venta.setCodigo_detalle_venta (String.valueOf(item));
    			detalle_venta.setCodigo_producto(codProducto);
    			detalle_venta.setDescripcion_producto(descripcion);
    			detalle_venta.setPrecio_producto(precio);
    			detalle_venta.setCantidad_producto(cantidad);
    			detalle_venta.setCodigo_venta(numfac);
    			detalle_venta.setValor_iva(iva);
    			detalle_venta.setValor_venta(subtotal);
    			
    			listaVentas.add(detalle_venta);
    			
    			
    			for (int i= 0; i < listaVentas.size(); i++) {
    				acusubtotal +=listaVentas.get(i).getValor_venta();
    				subtotaliva +=listaVentas.get(i).getValor_iva();
    			}
    			
    			totalpagar= acusubtotal + subtotaliva;
    			detalle_venta.setValor_total(totalpagar);
    			
    			request.setAttribute("listaventas", listaVentas);
    			request.setAttribute("totalsubtotal", acusubtotal);
    			request.setAttribute("totaliva", subtotaliva);
    			request.setAttribute("totalpagar", totalpagar);
    		}
    		
    		else if (accion.equals("GenerarVenta")) {
    			
    			
    			cedulaCliente=request.getParameter("cedulacliente");
    			String numFact=request.getParameter("numerofactura");
    			
    			Ventas ventas = new Ventas();
    			
    			ventas.setCodigo_venta(Long.parseLong(numFact));    			
    			ventas.setCedula_cliente(Long.parseLong(cedulaCliente));    		
    			ventas.setCedula_usuario(usuarios.getCedula_usuario());    		
    			ventas.setIva_venta(subtotaliva);    		
    			ventas.setValor_venta(acusubtotal);    		
    			ventas.setTotal_venta(totalpagar);
    		
    		
    			
    			int respuesta=0;
    			System.out.println("numerofactura");
    			try {
    				respuesta= TestJSONVentas.postJSON(ventas);
    				PrintWriter write = response.getWriter();
    				if(respuesta==200) {
    					System.out.println("Grabacion Exitosa: " + respuesta);
    				} else {
    					write.println ("Error Venta: " + respuesta);
    			}
    			write.close();
				
    			
			}catch (Exception e) {
				e.printStackTrace();
				
    			
				
    		}
    			
    		}//else{
    			 // ********* Muestro por primera vez el número de la factura *****************
    			    //try {
    				//numfac=TestJSONVentas.getConsecutivo();
    				//request.setAttribute("numerofactura", numfac);
    			    //} catch (Exception e) {
    				//e.printStackTrace();
    			   // }
    			//}

    		request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
    		break;
    	case "Reportes":
        	int opcion =0;
        	
        	if (accion.equals("ReporteUsuarios")) {
        		opcion =1;
        		try {
        			ArrayList<Usuarios> lista = TestJSON.getJSON();
        			request.setAttribute("listaUsuarios", lista);
        			request.setAttribute("opcion", opcion);
        		
        	     } catch (Exception e) {
        		 e.printStackTrace();
        	     }	 
        	}else if (accion.equals("ReporteClientes")) {
        		opcion =2;
        		try {
        			ArrayList<Clientes> lista = TestJSONClientes.getJSON();
         			request.setAttribute("listaClientes", lista);
         			request.setAttribute("opcion", opcion);
         		
         	        } catch (Exception e) {
         	        	e.printStackTrace();
         	        }
    	    	
    	    	 
    	     }else if (accion.equals("ReporteVentas")) {
         		opcion =3;
         		try {
         			//ArrayList<Ventas> lista = TestJSONVentas.getJSON();
          			//request.setAttribute("lisaVentas", lista);
          			request.setAttribute("opcion", opcion);
          		
          	        } catch (Exception e) {
          	        	e.printStackTrace();
          	        }
     	    	 }
        	
    		request.getRequestDispatcher("/Reportes.jsp").forward(request, response);

        
        	break;
        	
    	
        }  
}
} 
