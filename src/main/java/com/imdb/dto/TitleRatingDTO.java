package com.imdb.dto;

import lombok.Data;

/**
 * @developer -- ilkercolakoglu
 */

@Data
public class TitleRatingDTO extends BaseDTO {

    private Double averagerating;

    private Integer numVotes;

}
