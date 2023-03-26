package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PEDIDO_CABECERA")
@Entity(name = "PedidoCabeceraEntity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoCabeceraEntity {

	@Id
	@Column(name = "PEDIDO_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPedidoCabecera")
	@SequenceGenerator(sequenceName = "SEQ_PEDIDO_CABECERA", allocationSize = 1, name = "seqPedidoCabecera")
	private Long id;
	
	@Column(name = "CLIENTE_ID")
	private Long idCliente;
	
	@Column(name = "GLOSA")
	private String gloa;

	@Column(name = "FECHA_REGISTRO")
	private String fechaRegistro;
	
	@Column(name = "TOTAL")
	private Double total;
	
	@Column(name = "ESTADO")
	private String estado;
	
	//
	@OneToMany(mappedBy = "pedidoCabecera", cascade = CascadeType.ALL)
	@Where(clause = "estado='1'")
	private List<PedidoDetalleEntity> lstPedidoDetalle;

	public void calcularTotal() {
		Double tmpTotal = 0.0;
		
		for(PedidoDetalleEntity pde : lstPedidoDetalle) {
			if(isNull(lstPedidoDetalle) || lstPedidoDetalle.isEmpty() || isNull(pde)) {
					setTotal(0.0);
			}
			tmpTotal += pde.getSubTotal();
		}
		setTotal(tmpTotal);
	}
}
