package lotto.domain;

import lotto.domain.prize.Statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticTest {
    @Test
    @DisplayName("결제한 금액과 당첨금액을 통해 Statistic 을 생성한다.")
    void createStatisticWithPaymentAmountAndPrizeAmount() {
        int payAmount = 1000;
        int prizeAmount = 50_000;
        var statistic = Statistic.of(payAmount, prizeAmount);
        Assertions.assertEquals(statistic.getClass(), Statistic.class);
    }

    @Test
    @DisplayName("8000원을 결제해서 5000원을 당첨되면 62.5 % 의 수익률을 가진다.")
    void calculateYieldTest1() {
        int payAmount = 8000;
        int prizeAmount = 5000;
        var statistic = Statistic.of(payAmount, prizeAmount);
        Assertions.assertEquals(statistic.yieldRatio(), 62.5);
    }

    @Test
    @DisplayName("1000원을 결제해서 2,000,000,000원을 당첨되면 200_000_000.0 % 의 수익률을 가진다.")
    void calculateYieldTest2() {
        int payAmount = 1000;
        int prizeAmount = 2_000_000_000;
        var statistic = Statistic.of(payAmount, prizeAmount);
        Assertions.assertEquals(200_000_000.0, statistic.yieldRatio(), 0.01);
    }

    @Test
    @DisplayName("10000원을 결제해서 당첨이 되지 않으면 0.0 % 의 수익률을 가진다.")
    void calculateYieldTest3() {
        int payAmount = 10000;
        int prizeAmount = 0;
        var statistic = Statistic.of(payAmount, prizeAmount);
        Assertions.assertEquals(0.0, statistic.yieldRatio(), 0.01);
    }
}
