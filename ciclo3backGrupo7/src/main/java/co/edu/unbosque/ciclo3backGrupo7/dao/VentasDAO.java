package co.edu.unbosque.ciclo3backGrupo7.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.unbosque.ciclo3backGrupo7.model.Ventas;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import co.edu.unbosque.ciclo3backGrupo7.model.Consecutivo;

public interface VentasDAO extends JpaRepository<Ventas, Long> {
	@Query("select new co.edu.unbosque.ciclo3backGrupo7.model.Consecutivo(ifnull(max(v.codigo_venta),0)+1) from Ventas v")
	Optional<Consecutivo> obtenerConsecutivo();


}