package fr.sg.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Step1Test {

    @Test
    public void testEmptyString() {
        int output = SumCalculator.add("");
        assertEquals(0, output);
    }

    @Test
    public void testOneNumber() {
        int output = SumCalculator.add("1");
        assertEquals(1, output);
    }

    @Test
    public void testWithTwoNumbers() {
        int output = SumCalculator.add("1,2");
        assertEquals(3, output);
    }
}
