package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "PEDIDO_DETALLE")
@Entity(name = "PedidoDetalleEntity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PedidoDetalleEntity {

	@Id
	@Column(name = "PEDIDO_DETALLE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPedidoDetalle")
	@SequenceGenerator(sequenceName = "SEQ_PEDIDO_DETALLE", allocationSize = 1, name = "seqPedidoDetalle")
	private Long id;
	
	@JsonIgnore // Para evitar hacer bucles infinitos -> JsonBackReference
	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID", nullable = false)
	private PedidoCabeceraEntity pedidoCabecera;
	
	@Column(name = "PRODUCTO_ID")
	private Long idProducto;
		
	@Column(name = "CANTIDAD")
	private Double cantidad;
	
	@Column(name = "PRECIO")
	private Double precio;	
	
	@Column(name = "SUB_TOTAL")
	private Double subTotal;	
	
	@Column(name = "FECHA_REGISTRO")
	private String fechaRegistro;
	
	@Column(name = "ESTADO")
	private String estado;
	
	public void calcularSubTotal() {
		// validaciones -> 100 Desarrollo 30 pruebas
		
		if(isNull(cantidad)) {
			cantidad = 0.0;
		}
		if(isNull(precio)) {
			precio = 0.0;
		}
		setSubTotal(cantidad * precio);
	}

}