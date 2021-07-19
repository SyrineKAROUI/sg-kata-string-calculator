package fr.sg.kata;

import fr.sg.kata.exception.NegativeInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Step5Test {

    @Test
    public void testNegativeInputs() {
        NegativeInputException exception = assertThrows(NegativeInputException.class, () -> {
            SumCalculator.add("1,-2\n2,3,6");
        });
        assertEquals("Negatives not allowed :: -2 ", exception.getMessage());
    }

    @Test
    public void testTwoNegativeInputs() {
        NegativeInputException exception = assertThrows(NegativeInputException.class, () -> {
            SumCalculator.add("1,-2\n2,3,-6");
        });
        assertEquals("Negatives not allowed :: -2 -6 ", exception.getMessage());
    }

    @Test
    public void testThirdNegativeInputs() {
        NegativeInputException exception = assertThrows(NegativeInputException.class, () -> {
            SumCalculator.add("-1\n2,-2");
        });
        assertEquals("Negatives not allowed :: -1 -2 ", exception.getMessage());
    }
}
