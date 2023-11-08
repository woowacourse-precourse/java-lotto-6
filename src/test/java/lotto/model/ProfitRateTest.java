package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitRateTest {

    @DisplayName("수익률이 50퍼센트인 경우")
    @Test
    void calculateProfitRate() {
        ProfitRate profitRate = new ProfitRate();

        double reward = 5000;
        double purchaseAmount = 10000;
        long profitRateCompared = Math.round(reward / purchaseAmount * 100);

        profitRate.calculate(reward, purchaseAmount);
        Assertions.assertThat(profitRate.getProfitRate()).isEqualTo(profitRateCompared);
    }
}
