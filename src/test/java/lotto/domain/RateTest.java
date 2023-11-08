package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateTest {
    private static final int REWARD = 5000;
    private static final int PURCHASE_MONEY = 8000;
    private static final double RATE = (double) REWARD / PURCHASE_MONEY * 100;

    @Test
    @DisplayName("당첨률 확인 로직")
    public void createRate() {
        // when
        Rate rate = new Rate(PURCHASE_MONEY, REWARD);
        double actual = rate.getRate();

        // then
        assertThat(actual).isEqualTo(RATE);
    }

}