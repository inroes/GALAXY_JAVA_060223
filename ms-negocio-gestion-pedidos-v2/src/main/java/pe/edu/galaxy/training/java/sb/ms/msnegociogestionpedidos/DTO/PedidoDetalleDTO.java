package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoDetalleDTO {

	private Long id;
		
	//private PedidoCabeceraEntity pedidoCabecera;
	
	private Long idProducto;
		
	private Double cantidad;
	
	private Double precio;	
	
	private Double subTotal;	
	
}