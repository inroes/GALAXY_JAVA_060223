package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.entity.PedidoCabeceraEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.repository.PedidoCabeceraRepository;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.repository.PedidoDetalleRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService{

	// inyección por constructor usando lombok
	private final PedidoCabeceraRepository pedidoCabeceraRepository;
	private final PedidoDetalleRepository pedidoDetalleRepository;

	
	@Override
	public List<PedidoCabeceraEntity> findByLikeObject(PedidoCabeceraEntity t) throws ServiceException {
		return null;
	}

	@Override
	public Optional<PedidoCabeceraEntity> findById(Long id) throws ServiceException {
		try {
			log.info("id PedidoCabeceraEntity en servicio = " , id);
			return pedidoCabeceraRepository.findById(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException();
		}
	}

	@Override
	public PedidoCabeceraEntity save(PedidoCabeceraEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoCabeceraEntity update(PedidoCabeceraEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(PedidoCabeceraEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
