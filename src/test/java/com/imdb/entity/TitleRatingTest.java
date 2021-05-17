package com.imdb.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class TitleRatingTest {

    private TitleRating titleRating;

    @Before
    public void setup() {
        titleRating = new TitleRating();
        titleRating.setAveragerating(8.9);
        titleRating.setNumVotes(100);
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titleRating.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titleRating.toString());
    }

    @Test
    public void equalsTest() {
        TitleRating instanceToCompare = createTitleRating();
        TitleRating nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titleRating) && titleRating.equals(instanceToCompare));
        assertFalse(titleRating.equals(nullRequest));
        assertFalse(titleRating.equals(nullObject));
    }

    private TitleRating createTitleRating() {
        TitleRating titleRating = new TitleRating();
        titleRating.setAveragerating(8.9);
        titleRating.setNumVotes(100);
        return titleRating;
    }

}
