package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.DTO.PedidoCabeceraDTO;
import pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos.entity.PedidoCabeceraEntity;

// https://github.com/mapstruct/mapstruct

@Mapper(componentModel = "spring")
public interface PedidoMapper {
	
	PedidoCabeceraDTO toDTO(PedidoCabeceraEntity e);
	
	PedidoCabeceraEntity toEntity(PedidoCabeceraDTO dto);
	
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget PedidoCabeceraEntity entity, PedidoCabeceraEntity updateEntity);
}
