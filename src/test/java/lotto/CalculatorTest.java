package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;

    @Test
    void calculateRateTest() {
        calculator = new Calculator();
        double rate = calculator.calculateRate(50, 3);
        assertEquals(rate, 1666.7);
    }
}
