package com.imdb.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class TitlePrincipalTest {

    private TitlePrincipal titlePrincipal;

    @Before
    public void setup() {
        titlePrincipal = new TitlePrincipal();
        titlePrincipal.setOrdering(1234);
        titlePrincipal.setCategory(678);
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(titlePrincipal.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(titlePrincipal.toString());
    }

    @Test
    public void equalsTest() {
        TitlePrincipal instanceToCompare = createTitlePrincipal();
        TitlePrincipal nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(titlePrincipal) && titlePrincipal.equals(instanceToCompare));
        assertFalse(titlePrincipal.equals(nullRequest));
        assertFalse(titlePrincipal.equals(nullObject));
    }

    private TitlePrincipal createTitlePrincipal() {
        TitlePrincipal titlePrincipal = new TitlePrincipal();
        titlePrincipal.setOrdering(1234);
        titlePrincipal.setCategory(678);
        return titlePrincipal;
    }

}
