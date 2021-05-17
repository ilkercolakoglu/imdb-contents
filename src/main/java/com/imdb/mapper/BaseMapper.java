package com.imdb.mapper;

import com.imdb.dto.BaseDTO;
import com.imdb.entity.BaseEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

/**
 * @developer -- ilkercolakoglu
 */


public interface BaseMapper<Entity extends BaseEntity, DTO extends BaseDTO> {

    @Named("toEntity")
    Entity toEntity(DTO dto);

    @Named("toDTO")
    DTO toDTO(Entity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<Entity> toEntityList(List<DTO> dtoList);

    @IterableMapping(qualifiedByName = "toDto")
    List<DTO> toDTOList(List<Entity> entityList);


}
