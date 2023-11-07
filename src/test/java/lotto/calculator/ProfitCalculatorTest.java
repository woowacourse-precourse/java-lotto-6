package lotto.calculator;

import java.text.DecimalFormat;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.Rank;
import lotto.domain.calculator.ProfitCalculator;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitCalculatorTest {

    @DisplayName("수익률이 소수점 둘째자리에서 반올림 하는지 검증한다")
    @Test
    void 수익률_소수점_둘째자리에서_반올림_하는지_검증() {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        int purchaseAmount = 14000;
        Map<Rank, Integer> results = Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 1
        );

        double profitRate = profitCalculator.getProfitRate(purchaseAmount, results);
        DecimalFormat profitFormat = new DecimalFormat("#.#");
        String formattedProfitRate = profitFormat.format(profitRate);

        String expectedProfitRate = "35.7";

        assertThat(formattedProfitRate).isEqualTo(expectedProfitRate);
    }
}