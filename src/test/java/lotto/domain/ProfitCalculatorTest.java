package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    @DisplayName("당첨으로 얻은 상금을 총합한다.")
    @Test
    void getTotalProfit() {
        // given
        Map<Prize, Integer> lottosResult = new HashMap<>();
        lottosResult.put(Prize.FIFTH, 2);
        lottosResult.put(Prize.FOURTH, 1);
        ProfitCalculator profitCalculator = new ProfitCalculator(lottosResult);
        long expectedTotalProfit = 60000;
        // when, then
        assertThat(profitCalculator.getTotalProfit())
                .isEqualTo(expectedTotalProfit);
    }
}