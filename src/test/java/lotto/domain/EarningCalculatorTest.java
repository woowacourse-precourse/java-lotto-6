package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarningCalculatorTest {
    @Test
    void correctEarnings(){
        EarningCalculator calc = new EarningCalculator(8000, 5000);
        assertEquals(62.5, calc.compute());
    }
}