package com.imdb.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class TitleCrewDTOTest {

    private TitleCrewDTO titleCrewDTO;

    @Before
    public void setup() {
        titleCrewDTO = new TitleCrewDTO();
        titleCrewDTO.setDirectors("peter");
        titleCrewDTO.setWriters("w123");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titleCrewDTO.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titleCrewDTO.toString());
    }

    @Test
    public void equalsTest() {
        TitleCrewDTO instanceToCompare = createTitleCrewDTO();
        TitleCrewDTO nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titleCrewDTO) && titleCrewDTO.equals(instanceToCompare));
        assertFalse(titleCrewDTO.equals(nullRequest));
        assertFalse(titleCrewDTO.equals(nullObject));
    }

    private TitleCrewDTO createTitleCrewDTO() {
        TitleCrewDTO titleCrewDTO = new TitleCrewDTO();
        titleCrewDTO.setDirectors("peter");
        titleCrewDTO.setWriters("w123");
        return titleCrewDTO;
    }

}
