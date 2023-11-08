package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("수익률 계산 테스트")
    @Test
    void rateOFProfitTest() {
        Calculator calculator = new Calculator();
        int lottoCount = 10;

        assertEquals(15600.0, calculator.rateOFProfit(
                List.of(0, 0, 1, 1, 2), lottoCount));
    }
}