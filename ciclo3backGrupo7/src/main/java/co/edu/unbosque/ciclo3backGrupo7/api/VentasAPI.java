package co.edu.unbosque.ciclo3backGrupo7.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3backGrupo7.dao.VentasDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Ventas;

@RestController
@RequestMapping("ventas")
public class VentasAPI {
	
	@Autowired
	private VentasDAO ventasDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}

}