package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateTest {

    @DisplayName("수익률 게산 테스트")
    @Test
    public void testRateCalculation() {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.updatePrizeCount(Prize.FIRST);
        prizeResult.updatePrizeCount(Prize.SECOND);
        prizeResult.updatePrizeCount(Prize.THIRD);

        Money money = new Money(5000);

        Rate rate = new Rate(money, prizeResult);

        double expectedRate = (prizeResult.getPrizeCount(Prize.FIRST) * Prize.FIRST.getMoney() +
                prizeResult.getPrizeCount(Prize.SECOND) * Prize.SECOND.getMoney() +
                prizeResult.getPrizeCount(Prize.THIRD) * Prize.THIRD.getMoney()) * 0.1 / money.getTicket();

        assertEquals(expectedRate, rate.getRate(), 0.001);
    }
}