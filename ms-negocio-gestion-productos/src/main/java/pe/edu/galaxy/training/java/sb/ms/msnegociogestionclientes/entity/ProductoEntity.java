package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCTO")
@Entity(name = "ProductoEntity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoEntity {

	@Id
	@Column(name = "ID_PRODUCTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="El nombre es requerido")
	@Size(min=5,max=240, message="El nombre debe tener como mínimo {min} y máximo {max} caracteres")
	@Column(name = "nombre",length=240,nullable=false)
	private String nombre;
	

	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "stock_minimo")
	private String stockMinimo;
	
	@Column(name = "stock_maximo")
	private String stockMaximo;
	
	@Column(name = "ESTADO")
	private String estado;

}
