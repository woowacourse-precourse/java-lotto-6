package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitRateCalculatorTest {
    @DisplayName("수익률 계산에 대한 테스트")
    @Test
    void success() {
        // give
        int firstPrizeCount = 1;
        int secondPrizeCount = 1;
        int thirdPrizeCount = 1;
        int fourthPrizeCount = 1;
        int fifthPrizeCount = 1;
        int purchasedLottoCount = 61;

        String profitRate = ProfitRateCalculator.calculate(firstPrizeCount, secondPrizeCount, thirdPrizeCount,
                fourthPrizeCount, fifthPrizeCount, purchasedLottoCount);

        assertThat(profitRate).isEqualTo("3330418032.8");
    }

}