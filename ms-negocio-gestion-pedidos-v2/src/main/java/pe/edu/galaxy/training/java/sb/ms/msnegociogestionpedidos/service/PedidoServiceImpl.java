package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.DTO.PedidoCabeceraDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.DTO.PedidoDetalleDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.entity.PedidoCabeceraEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.entity.PedidoDetalleEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.repository.PedidoCabeceraRepository;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.repository.PedidoDetalleRepository;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service.client.clientes.ClienteDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service.client.clientes.ClienteService;

@Slf4j
@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService{

	// inyección por constructor usando lombok
	private final PedidoCabeceraRepository pedidoCabeceraRepository;
	
	private final PedidoDetalleRepository pedidoDetalleRepository;

	private final ClienteService clienteService;
	
	@Override
	public List<PedidoCabeceraDTO> findByLikeObject(PedidoCabeceraDTO t) throws ServiceException {
		return null;
	}

	@Override
	public Optional<PedidoCabeceraDTO> findById(Long id) throws ServiceException {
		try {
			log.info("id PedidoCabeceraEntity en servicio = " , id);
			Optional<PedidoCabeceraEntity> optPedidoCabeceraEntity = pedidoCabeceraRepository.findById(id);
			
			if(optPedidoCabeceraEntity.isPresent()) {
				PedidoCabeceraEntity pedidoCabeceraEntity = optPedidoCabeceraEntity.get();
				
				PedidoCabeceraDTO pedidoCabeceraDTO = this.toDTO(pedidoCabeceraEntity);
				
				ClienteDTO clienteDTO = clienteService.findById(id);
				log.info("clienteDTO {}" , clienteDTO);
				
				pedidoCabeceraDTO.setClienteDTO(clienteDTO);
				
				List<PedidoDetalleDTO> lstPedidoDetalleDTO = pedidoCabeceraEntity.getLstPedidoDetalle().stream().map(item -> this.toDTO(item)).toList();

				pedidoCabeceraDTO.setLstPedidoDetalle(lstPedidoDetalleDTO);
				
				return Optional.of(pedidoCabeceraDTO);
				//return Optional.ofNullable(pedidoCabeceraDTO);

			}
			return null;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ServiceException();
		}
		//return null;
	}

	@Override
	public PedidoCabeceraDTO save(PedidoCabeceraDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoCabeceraDTO update(PedidoCabeceraDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(PedidoCabeceraDTO t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private PedidoCabeceraDTO toDTO(PedidoCabeceraEntity e) {
		return PedidoCabeceraDTO
			.builder()
			.id(e.getId())
			.glosa(e.getGlosa())
			.fechaRegistro(e.getFechaRegistro())
			.total(e.getTotal())
			.build();		
		 
	}

	private PedidoDetalleDTO toDTO(PedidoDetalleEntity e) {
		return PedidoDetalleDTO
			.builder()
			.id(e.getId())
			.idProducto(e.getIdProducto())
			.cantidad(e.getCantidad())
			.precio(e.getPrecio())
			.subTotal(e.getSubTotal())
			.build();		
		 
	}

}
