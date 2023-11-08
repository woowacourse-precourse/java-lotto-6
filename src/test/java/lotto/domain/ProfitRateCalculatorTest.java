package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitRateCalculatorTest {

    @DisplayName("수익률을 계산하면 구입 금액을 총 상금으로 나눈 값을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"8000, 5000, 62.5", "8000, 10000, 125.0", "7000, 1500000, 21428.6"})
    void calculate_Success(int purchaseAmount, long reward, double expected) {
        // given
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();

        // when
        double profitRate = profitRateCalculator.calculate(purchaseAmount, reward);

        // then
        Assertions.assertThat(Math.round(profitRate * 10) / 10.0).isEqualTo(expected);
    }
}
