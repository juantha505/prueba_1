package co.edu.unbosque.ciclo3backGrupo7.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;
import co.edu.unbosque.ciclo3backGrupo7.model.Consecutivo;
import co.edu.unbosque.ciclo3backGrupo7.dao.VentasDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Ventas;
import java.util.List;


@RestController 
@RequestMapping("ventas")
public class VentasAPI {

	@Autowired
	private VentasDAO ventasDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Ventas ventas) {
		ventasDAO.save(ventas);
	}
	 @GetMapping("/listar")
	 public List <Ventas> listar(){
		 return ventasDAO.findAll();
		 
	 }
	
	
	@GetMapping("/consecutivo")
	public Optional<Consecutivo> buscarNextId(){
		return ventasDAO.obtenerConsecutivo();
	}
}
