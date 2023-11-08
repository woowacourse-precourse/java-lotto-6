package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitRateTest {

    @DisplayName("수익률 계산 점검")
    @Test
    public void profitRate() {
        int deposit = 8_000;
        long total = 1_500_000;
        double rate = ((double) total / deposit) * 100;

        ProfitRate profitRate = new ProfitRate(total, deposit);

        assertThat(profitRate.getProfitRate()).isEqualTo(rate);
    }

    @DisplayName("소수점 첫 번째 자리까지 나온다.")
    @Test
    public void firstDecimal() {
        int deposit = 8_000;
        long total = 5000;
        double rate = 62.5;

        ProfitRate profitRate = new ProfitRate(total, deposit);
        System.out.println(profitRate.getProfitRate());
        assertThat(profitRate.getProfitRate()).isEqualTo(rate);
    }
}
