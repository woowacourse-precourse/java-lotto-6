package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    @DisplayName("수익률이 제대로 계산되는지 확인한다.")
    @Test
    void profitCalculatorTest() {
        // given
        int purchase = 8000;
        int winning = 5000;

        // when, then
        Assertions.assertThat(ProfitCalculator.calculateProfitPercentage(purchase, winning))
            .isEqualTo(62.5);
    }
}