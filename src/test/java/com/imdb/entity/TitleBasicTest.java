package com.imdb.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class TitleBasicTest {

    private TitleBasic titleBasic;

    @Before
    public void setup() {
        titleBasic = new TitleBasic();
        titleBasic.setId("1");
        titleBasic.setOriginalTitle("Amolet");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titleBasic.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titleBasic.toString());
    }

    @Test
    public void equalsTest() {
        TitleBasic instanceToCompare = createTitleBasic();
        TitleBasic nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titleBasic) && titleBasic.equals(instanceToCompare));
        assertFalse(titleBasic.equals(nullRequest));
        assertFalse(titleBasic.equals(nullObject));
    }

    private TitleBasic createTitleBasic() {
        TitleBasic titleBasic = new TitleBasic();
        titleBasic.setId("1");
        titleBasic.setOriginalTitle("Amolet");
        return titleBasic;
    }

}
