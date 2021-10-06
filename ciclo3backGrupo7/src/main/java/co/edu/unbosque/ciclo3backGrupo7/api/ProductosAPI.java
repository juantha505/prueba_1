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

import co.edu.unbosque.ciclo3backGrupo7.dao.ProductosDAO;
import co.edu.unbosque.ciclo3backGrupo7.model.Productos;



@RestController // Indica que esta clase es de tipo REST
@RequestMapping("productos")
public class ProductosAPI {
	
	@Autowired // inyecta la dependencia de todos los metodos JPA para UsuariosDAO
    private ProductosDAO productosDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Productos productos) {
		productosDAO.save(productos);		
	}
	private ProductosDAO productosController;
	
	@GetMapping("/listar")
	public List<Productos> listar () {
		return productosDAO.findAll();
		
	}
	
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		productosDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Productos productos) {
		productosDAO.save(productos);
		
	

    
  }
}