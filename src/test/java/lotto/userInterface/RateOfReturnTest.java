package lotto.userInterface;

import lotto.domain.RateOfReturn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RateOfReturnTest {
    private static final int INVESTMENT = 1000;
    private static final int PROFIT = 55000;
    private static final double EXPECTED_RATE = 5500.0;

    @DisplayName("수익률 계산 기능 테스트")
    @Test
    void testCalculateRateOfReturn() {
        double actualRate = RateOfReturn.rateOfReturn(INVESTMENT, PROFIT);
        assertEquals(EXPECTED_RATE, actualRate);
    }
}
