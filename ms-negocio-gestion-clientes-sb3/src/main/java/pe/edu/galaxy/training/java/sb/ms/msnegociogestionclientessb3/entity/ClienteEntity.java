package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientessb3.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TBL_CLIENTE")
@Entity(name = "ClienteEntity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteEntity {

	@Id
	@Column(name = "CLIENTE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
	@SequenceGenerator(sequenceName = "SEQ_CLIENTE", allocationSize = 1, name = "seqCliente")
	private Long id;
	
	@NotNull(message="La razon social es requerida")
	@Size(min=5,max=240, message="La razon social debe tener como mínimo {min} y máximo {max} caracteres")
	@Column(name = "RAZON_SOCIAL",length=240,nullable=false)
	private String razonSocial;
	
	@Size(min=11,max=11, message="El ruc debe contener {min} caracteres")
	@Column(name = "RUC")
	private String ruc;

	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "ESTADO")
	private String estado;
	

}
