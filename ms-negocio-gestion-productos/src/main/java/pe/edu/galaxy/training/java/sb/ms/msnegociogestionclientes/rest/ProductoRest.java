package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity.ProductoEntity;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service.ProductoService;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.service.ServiceException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/productos")
public class ProductoRest {
	private final ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<?> findByLikeObject() throws ServiceException
	{
		try {
			log.info("objeto Producto en EndPoint = ");

			return ResponseEntity.ok(productoService.findByLikeObject(null));
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new ServiceException();
		}	
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ProductoEntity productoEntity) throws ServiceException
	{
		try {
			log.info("objeto Producto en EndPoint = ");

			return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(productoEntity));
			
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
