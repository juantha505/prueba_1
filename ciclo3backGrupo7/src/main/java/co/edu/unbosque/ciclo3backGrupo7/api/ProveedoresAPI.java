package co.edu.unbosque.ciclo3backGrupo7.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3backGrupo7.dao.ProveedoresDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Proveedores;

@RestController // Indica que esta clase es de tipo REST
@RequestMapping("proveedores")
public class ProveedoresAPI {
	
	@Autowired // inyecta la dependencia de todos los metodos JPA para UsuariosDAO
    private ProveedoresDAO proveedoresDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);		
	}
	private ProveedoresDAO proveedorController;
	
	@GetMapping("/listar")
	public List<Proveedores> listar () {
		return proveedoresDAO.findAll();
		
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		proveedoresDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Proveedores proveedores) {
		proveedoresDAO.save(proveedores);
		
	

    
  }
}