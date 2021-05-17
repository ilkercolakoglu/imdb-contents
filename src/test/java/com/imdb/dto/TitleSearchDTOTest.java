package com.imdb.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class TitleSearchDTOTest {

    private TitleSearchDTO titleSearchDTO;

    @Before
    public void setup() {
        titleSearchDTO = new TitleSearchDTO();
        titleSearchDTO.setPrimaryTitle("Hamlet");
        titleSearchDTO.setOriginalTitle("Amolet");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titleSearchDTO.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titleSearchDTO.toString());
    }

    @Test
    public void equalsTest() {
        TitleSearchDTO instanceToCompare = createTitleSearchDTO();
        TitleSearchDTO nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titleSearchDTO) && titleSearchDTO.equals(instanceToCompare));
        assertFalse(titleSearchDTO.equals(nullRequest));
        assertFalse(titleSearchDTO.equals(nullObject));
    }

    private TitleSearchDTO createTitleSearchDTO() {
        TitleSearchDTO titleSearchDTO = new TitleSearchDTO();
        titleSearchDTO.setPrimaryTitle("Hamlet");
        titleSearchDTO.setOriginalTitle("Amolet");
        return titleSearchDTO;
    }


}
