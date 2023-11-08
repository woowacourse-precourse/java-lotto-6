package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitRateTest {

    @DisplayName("수익률 계산")
    @Test
    void getRate() {
        // 일반적인 수익률 계산
        long spendCost = 10000;
        long getCost = 8000;

        ProfitRate rate = new ProfitRate(spendCost, getCost);
        double expectedRate = (double) getCost / spendCost * 100;
        assertThat(rate.getRate()).isEqualTo(expectedRate);

        getCost = 0;

        ProfitRate zeroIncomeRate = new ProfitRate(spendCost, getCost);
        expectedRate = (double) getCost / spendCost * 100;
        assertThat(zeroIncomeRate.getRate()).isEqualTo(expectedRate);
    }
}