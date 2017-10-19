package com.iwcn.master.repositories;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.iwcn.master.pro.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	Producto findById (int id);
	
	@Query(value = "SELECT * FROM PRODUCTO", nativeQuery = true)
	List<Producto> selectAll();
	
	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.codigo=?1 WHERE p.id=?2")
	int setNewCodigo(String codigo, int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.nombre=?1 WHERE p.id=?2")
	int setNewNombre(String nombre, int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.descripcion=?1 WHERE p.id=?2")
	int setNewDescripcion(String descripcion, int id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.precio=?1 WHERE p.id=?2")
	int setNewPrecio(Integer precio, int id);

}
