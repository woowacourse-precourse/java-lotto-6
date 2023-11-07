package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfitRateTest {

    @Test
    void calculate_수익률이_50퍼센트인_경우() {
        ProfitRate profitRate = new ProfitRate();

        double reward = 5000;
        double purchaseAmount = 10000;

        profitRate.calculate(reward, purchaseAmount);
        Assertions.assertThat(profitRate.getProfitRate()).isEqualTo(reward / purchaseAmount);
    }
}
