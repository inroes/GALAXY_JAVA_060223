package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service.PedidoService;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service.ServiceException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/pedidos")
public class PedidoRest {
	private final PedidoService pedidoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) throws ServiceException
	{
		try {
			log.info("objeto Pedido en EndPoint = ");

			return ResponseEntity.ok(pedidoService.findById(id).get());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ServiceException();
		}	
	}	
	
	/*
	 * 	@GetMapping("/by-razonSocial")
	public ResponseEntity<?> findByLikeRazonSocial(@RequestParam String razonSocial){
		try {
			
			ClienteDTO clienteDTO= new ClienteDTO();
			clienteDTO.setRazonSocial(razonSocial);
			List<ClienteDTO> clientes= clienteService.findByLikeObject(clienteDTO);
			if (clientes.isEmpty()) {
				return ResponseEntity.noContent().build();				
			}
			return  ResponseEntity.ok(clientes);
		} catch (Exception e) {
			//log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
	 * 
	 */
}
