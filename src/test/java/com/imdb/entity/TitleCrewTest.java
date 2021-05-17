package com.imdb.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class TitleCrewTest {

    private TitleCrew titleCrew;

    @Before
    public void setup() {
        titleCrew = new TitleCrew();
        titleCrew.setWriters("w1234");
        titleCrew.setDirectors("d1234");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titleCrew.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titleCrew.toString());
    }

    @Test
    public void equalsTest() {
        TitleCrew instanceToCompare = createTitleCrew();
        TitleCrew nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titleCrew) && titleCrew.equals(instanceToCompare));
        assertFalse(titleCrew.equals(nullRequest));
        assertFalse(titleCrew.equals(nullObject));
    }

    private TitleCrew createTitleCrew() {
        TitleCrew titleCrew = new TitleCrew();
        titleCrew.setWriters("w1234");
        titleCrew.setDirectors("d1234");
        return titleCrew;
    }

}
