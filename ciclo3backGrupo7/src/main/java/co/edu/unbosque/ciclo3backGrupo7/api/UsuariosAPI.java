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

import co.edu.unbosque.ciclo3backGrupo7.dao.UsuariosDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Usuarios;



@RestController // Indica que esta clase es de tipo REST
@RequestMapping("usuarios")
public class UsuariosAPI {
	
	@Autowired // inyecta la dependencia de todos los metodos JPA para UsuariosDAO
    private UsuariosDAO usuariosDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);		
	}
	private UsuariosDAO usuarioController;
	
	@GetMapping("/listar")
	public List<Usuarios> listar () {
		return usuariosDAO.findAll();
		
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		usuariosDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuarios usuarios) {
		usuariosDAO.save(usuarios);
		
	

    
  }
}
