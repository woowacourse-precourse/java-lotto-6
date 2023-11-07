package lotto.userInterface;

import lotto.domain.RateOfReturn;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RateOfReturnTest {

    @DisplayName("수익률 계산 기능 테스트")
    @Test
    void testCalculateRateOfReturn() {
        int investment = 1000;
        int profit = 55000;
        double actualRate = RateOfReturn.rateOfReturn(investment, profit);
        double expectedRate = 5500.0;
        assertEquals(expectedRate, actualRate);
    }
}
