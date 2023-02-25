package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.ClienteEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.repository.ClienteRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService{

	// inyección por constructor usando lombok
	private final ClienteRepository clienteRepository;
	
	
	@Override
	public List<ClienteEntity> findByLikeObject(ClienteEntity t) throws ServiceException {
		try {
			log.info("objeto Cliente en servicio = " , t);
			return clienteRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException();
		}
	}

	@Override
	public Optional<ClienteEntity> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public ClienteEntity save(ClienteEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteEntity update(ClienteEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(ClienteEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
