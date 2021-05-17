package com.imdb.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */

@RunWith(MockitoJUnitRunner.class)
public class TitleBasicDTOTest {

    private TitleBasicDTO titleBasicDTO;

    @Before
    public void setup() {
        titleBasicDTO = new TitleBasicDTO();
        titleBasicDTO.setId("1");
        titleBasicDTO.setOriginalTitle("12345678");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titleBasicDTO.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titleBasicDTO.toString());
    }

    @Test
    public void equalsTest() {
        TitleBasicDTO instanceToCompare = createTitleBasicDTO();
        TitleBasicDTO nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titleBasicDTO) && titleBasicDTO.equals(instanceToCompare));
        assertFalse(titleBasicDTO.equals(nullRequest));
        assertFalse(titleBasicDTO.equals(nullObject));
    }

    private TitleBasicDTO createTitleBasicDTO() {
        TitleBasicDTO titleBasicDTO = new TitleBasicDTO();
        titleBasicDTO.setId("1");
        titleBasicDTO.setOriginalTitle("12345678");
        return titleBasicDTO;
    }


}
