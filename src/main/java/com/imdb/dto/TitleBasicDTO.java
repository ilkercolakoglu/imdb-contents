package com.imdb.dto;

import lombok.Data;

/**
 * @developer -- ilkercolakoglu
 */

@Data
public class TitleBasicDTO extends BaseDTO {

    private String id;

    private String titleType;

    private String primaryTitle;

    private String originalTitle;

    private Boolean isAdult;

    private Integer startYear;

    private Integer endYear;

    private Integer runTimeMinutes;

    private String genres;

    private TitleCrewDTO titleCrew;

    private TitleRatingDTO titleRating;

}
