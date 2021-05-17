package com.imdb.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @developer -- ilkercolakoglu
 */
public class NameBasicTest {


    private NameBasic nameBasic;

    @Before
    public void setup() {
        nameBasic = new NameBasic();
        nameBasic.setId("1");
        nameBasic.setPrimaryName("Brad");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(nameBasic.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(nameBasic.toString());
    }

    @Test
    public void equalsTest() {
        NameBasic instanceToCompare = createNameBasic();
        NameBasic nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(nameBasic) && nameBasic.equals(instanceToCompare));
        assertFalse(nameBasic.equals(nullRequest));
        assertFalse(nameBasic.equals(nullObject));
    }

    private NameBasic createNameBasic() {
        NameBasic nameBasic = new NameBasic();
        nameBasic.setId("1");
        nameBasic.setPrimaryName("Brad");
        return nameBasic;
    }

}
