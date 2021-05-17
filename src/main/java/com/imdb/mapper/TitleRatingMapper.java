package com.imdb.mapper;

import com.imdb.dto.TitleCrewDTO;
import com.imdb.dto.TitleRatingDTO;
import com.imdb.entity.TitleCrew;
import com.imdb.entity.TitleRating;
import org.mapstruct.Mapper;

/**
 * @developer -- ilkercolakoglu
 */
@Mapper(componentModel = "spring")
public interface TitleRatingMapper extends BaseMapper<TitleRating, TitleRatingDTO> {

}
