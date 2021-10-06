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

import co.edu.unbosque.ciclo3backGrupo7.dao.ClientesDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Clientes;

@RestController // Indica que esta clase es de tipo REST
@RequestMapping("clientes")
public class ClientesAPI {
	
	@Autowired // inyecta la dependencia de todos los metodos JPA para UsuariosDAO
    private ClientesDAO clientesDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Clientes clientes) {
		clientesDAO.save(clientes);		
	}
	private ClientesDAO clienteController;
	
	@GetMapping("/listar")
	public List<Clientes> listar () {
		return clientesDAO.findAll();
		
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		clientesDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Clientes clientes) {
		clientesDAO.save(clientes);
		
	

    
  }
}
