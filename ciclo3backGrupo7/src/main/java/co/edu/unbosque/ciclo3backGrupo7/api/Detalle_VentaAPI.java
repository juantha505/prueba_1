package co.edu.unbosque.ciclo3backGrupo7.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3backGrupo7.dao.Detalle_VentaDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Detalle_Ventas;

@RestController
@RequestMapping("detalle_venta")
public class Detalle_VentaAPI {
	
	@Autowired
	private Detalle_VentaDAO detalle_ventaDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Detalle_Ventas detalle_venta){
		detalle_ventaDAO.save(detalle_venta);
	}

}