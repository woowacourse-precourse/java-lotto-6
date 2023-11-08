package lotto.domain.answer.rate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryRateServiceTest {
    @Test
    @DisplayName("총 수익률을 구한다")
    void 총수익률계산() {
        // GIVEN
        Long cash = 990000L;
        Long winningPrice = 24000L;

        // WHEN
        Double returnOnInvestment = LotteryRateService.getReturnOnInvestment(cash, winningPrice);

        // THEN
        assertEquals(returnOnInvestment, 2.42d);
    }

}