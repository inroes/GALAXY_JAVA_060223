package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.entity.PedidoCabeceraEntity;

@Repository
public interface PedidoCabeceraRepository extends JpaRepository<PedidoCabeceraEntity, Long> {

	
}
