package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	
}
