package fr.sg.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Step2Test {

    @Test
    public void testWithFourNumbers() {
        int output = SumCalculator.add("1,2,3,4");
        assertEquals(10, output);
    }

    @Test
    public void testWithTenNumbers() {
        int output = SumCalculator.add("1,10,20,30,40,50,60,70,80,90,100");
        assertEquals(551, output);
    }
}
