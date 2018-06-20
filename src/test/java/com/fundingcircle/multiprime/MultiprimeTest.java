package com.fundingcircle.multiprime;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MultiprimeTest {

    private Multiprime multiprime = new Multiprime();

    @Test
    public void getTable() {
        assertEquals(6, multiprime.getTable(5).length);
        assertArrayEquals(new int[][]{{0, 2}, {2, 4}}, multiprime.getTable(1));
        assertArrayEquals(new int[]{0, 2, 3, 5, 7, 11}, multiprime.getTable(5)[0]);
        assertArrayEquals(new int[]{0, 2, 3, 5}, multiprime.getTable(3)[0]);
        assertArrayEquals(new int[]{0, 2, 3, 5, 7, 11, 13, 17}, multiprime.getTable(7)[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTableExceptionZero() {
        multiprime.getTable(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTableExceptionNegative() {
        multiprime.getTable(-1);
    }
}