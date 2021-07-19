package fr.sg.kata;

import fr.sg.kata.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Step3Test {

    @Test
    public void testWithNewLineAndDelimiter() {
        int output = SumCalculator.add("1\n2,3");
        assertEquals(6, output);
    }

    @Test
    public void testInvalidInput() {
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            SumCalculator.add("1,\n");
        });
        assertEquals("Invalid Input!", exception.getMessage());
    }

}
