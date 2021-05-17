package com.imdb.mapper;

import com.imdb.dto.TitleCrewDTO;
import com.imdb.entity.TitleCrew;
import org.mapstruct.Mapper;

/**
 * @developer -- ilkercolakoglu
 */
@Mapper(componentModel = "spring")
public interface TitleCrewMapper extends BaseMapper<TitleCrew, TitleCrewDTO> {

}
