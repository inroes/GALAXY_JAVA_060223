package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.service.client.clientes.ClienteDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoCabeceraDTO {

	//DTO son limpios sin anotaciones, sin tabla ni entidad
	private Long id;
	
	//private Long idCliente; TRANSFORMAR
	private ClienteDTO clienteDTO;
	
	private String glosa;

	private String fechaRegistro;
	
	private Double total;
	
	//private String estado;
	
	private List<PedidoDetalleDTO> lstPedidoDetalle;

	
}
