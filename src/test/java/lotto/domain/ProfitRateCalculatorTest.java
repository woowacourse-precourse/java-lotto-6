package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProfitRateCalculatorTest {

    @DisplayName("")
    @ParameterizedTest
    @CsvSource(value = {"8000, 5000, 62.5", "8000, 10000, 125.0", "7000, 1500000, 21428.6"})
    void calculate(int purchaseAmount, long reward, double expected) {
        // given
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();

        // when
        double profitRate = profitRateCalculator.calculate(purchaseAmount, reward);

        // then
        Assertions.assertThat(profitRate).isEqualTo(expected);
    }

}