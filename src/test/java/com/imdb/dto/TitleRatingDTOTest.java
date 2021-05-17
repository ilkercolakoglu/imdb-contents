package com.imdb.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class TitleRatingDTOTest {

    private TitleRatingDTO titleRatingDTO;

    @Before
    public void setup() {
        titleRatingDTO = new TitleRatingDTO();
        titleRatingDTO.setAveragerating(9.2);
        titleRatingDTO.setNumVotes(100);
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titleRatingDTO.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titleRatingDTO.toString());
    }

    @Test
    public void equalsTest() {
        TitleRatingDTO instanceToCompare = createTitleRatingDTO();
        TitleRatingDTO nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titleRatingDTO) && titleRatingDTO.equals(instanceToCompare));
        assertFalse(titleRatingDTO.equals(nullRequest));
        assertFalse(titleRatingDTO.equals(nullObject));
    }

    private TitleRatingDTO createTitleRatingDTO() {
        TitleRatingDTO titleRatingDTO = new TitleRatingDTO();
        titleRatingDTO.setAveragerating(9.2);
        titleRatingDTO.setNumVotes(100);
        return titleRatingDTO;
    }

}
