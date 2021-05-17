package com.imdb.mapper;

import com.imdb.dto.TitleBasicDTO;
import com.imdb.entity.TitleBasic;
import org.mapstruct.Mapper;

/**
 * @developer -- ilkercolakoglu
 */
@Mapper(componentModel = "spring", uses = {TitleCrewMapper.class, TitleRatingMapper.class})
public interface TitleBasicMapper extends BaseMapper<TitleBasic, TitleBasicDTO> {

}
