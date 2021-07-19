package fr.sg.kata;

import fr.sg.kata.exception.InvalidCustomDelimiterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Step4Test {

    @Test
    public void testCustomDelimiter() {
        int output = SumCalculator.add("//;\n1;2");
        assertEquals(3, output);
    }

    @Test
    public void testInvalidCustomDelimiter() {
        InvalidCustomDelimiterException exception = assertThrows(InvalidCustomDelimiterException.class, () -> {
            SumCalculator.add("//;8\n1;2");
        });
        assertEquals("Invalid Custom Delimiter!", exception.getMessage());
    }
}
