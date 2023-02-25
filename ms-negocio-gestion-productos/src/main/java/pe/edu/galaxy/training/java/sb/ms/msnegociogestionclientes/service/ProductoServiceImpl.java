package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.ProductoEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.repository.ProductoRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService{

	// inyección por constructor usando lombok
	private final ProductoRepository productoRepository;
	
	
	@Override
	public List<ProductoEntity> findByLikeObject(ProductoEntity t) throws ServiceException {
		try {
			log.info("objeto Cliente en servicio = " , t);
			return productoRepository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException();
		}
	}

	@Override
	public Optional<ProductoEntity> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public ProductoEntity save(ProductoEntity t) throws ServiceException {
		try {
			log.info("objeto Cliente en servicio = " , t);
			return productoRepository.save(t);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException();
		}
	}

	@Override
	public ProductoEntity update(ProductoEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(ProductoEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
