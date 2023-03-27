package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service.client.clientes;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class ClienteServiceImpl implements ClienteService{

	// Clasica
	
	/*
	private String url = "http://localhost:8081/v1/clientes/";

	// inyección por constructor con lombok
	private final RestTemplate restTemplate;
	
	@Override
	public ClienteDTO findById(Long id) {
		ResponseEntity<ClienteDTO> clienteDTO = restTemplate.getForEntity(url + id, ClienteDTO.class);
		return clienteDTO.getBody();
	}
	*/
	
	// OPTIMA
	private final RestTemplate restTemplate; 
	// como esta con @RequiredArgsConstructor  debe estar inyectado por lombok
	
	private DiscoveryClient discoveryClient;
	private String msName = "ms-negocio-gestion-clientes"; // host.docker.internal:ms-negocio-gestion-clientes:8082
	
	private String url="";
	
	@Override
	public ClienteDTO findById(Long id) {
		this.url=this.getURI()+"/v1/clientes/"+id;
		log.info("url {}",url);
		ResponseEntity<ClienteDTO>  clienteDTO=	restTemplate.getForEntity(url, ClienteDTO.class);
		log.info("clienteDTO  ClienteServiceImpl {}",clienteDTO);
		return clienteDTO.getBody();
	}
	
	
	private String getURI() {
		
		if (Objects.isNull(discoveryClient)) {
			log.info("discoveryClient is null");
			return null;
		}
		List<ServiceInstance> instances = discoveryClient.getInstances(msName);

		if (Objects.isNull(instances) || instances.isEmpty()) {
			log.info("instances is null");
			return null;
		}
		
		log.info("instances.get(0).getHost() => {}",instances.get(0).getHost());
		
		String uri=instances.get(0).getUri().toString();		
		log.info("uri => {}", uri);
		
		return uri;
	}
	
	
	
}
