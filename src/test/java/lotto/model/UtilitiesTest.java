package lotto.model;

import org.junit.jupiter.api.Test;

import static lotto.model.Utilities.divide;
import static lotto.model.Utilities.inputIntegerParsing;
import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    @Test
    public void testInputIntegerParsing() {
        String input = "8000";
        int expected = 8000;

        int result = inputIntegerParsing(input);

        assertEquals(expected, result);
    }

    @Test
    public void testDivideWithValidValues() {
        double dividend = 8000;
        double divisor = 1000;
        double expected = 8;

        double result = divide(dividend, divisor);

        assertEquals(expected, result);
    }

}