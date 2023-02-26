package pe.edu.galaxy.training.java.sb.ms.msnegociogestionproductos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionproductos.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

	
}
