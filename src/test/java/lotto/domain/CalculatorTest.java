package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({"0, false, 0", "1, false, 0", "2, false, 0", "3, false, 5000", "4, false, 50000", "5, false, 1500000", "6, false, 2000000000"})
    void calculateReturn은_보너스가_맞지_않을_때_lottoCount에_맞게_계산한다(int lottoCount, boolean isBonus, int expected) {
        int returnCash = Calculator.calculateReturn(lottoCount, isBonus);
        assertEquals(expected, returnCash);
    }

    @ParameterizedTest
    @CsvSource({"0, true, 0", "1, true, 0", "2, true, 0", "3, true, 5000", "4, true, 50000", "5, true, 30000000", "6, true, 2000000000"})
    void calculateReturn은_보너스가_맞을_때_lottoCount에_맞게_계산한다(int lottoCount, boolean isBonus, int expected) {
        int returnCash = Calculator.calculateReturn(lottoCount, isBonus);
        assertEquals(expected, returnCash);
    }

    @ParameterizedTest
    @CsvSource({"1000, 8000, 12.5", "1000, 3000, 33.3", "1000, 1000, 100.0", "200000000, 1000, 20000000.0"})
    void calculateRateOfReturn은_백분율화_하여_출력한다(int returnTotalCash, int cash, double expected) {
        double rateOfReturn = Calculator.calculateRateOfReturn(returnTotalCash, cash);
        assertEquals(rateOfReturn, expected);
    }
}