package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitCalculatorTest {

    @DisplayName("계산된 수익률을 소수점 둘째 자리에서 반올림하여 표기한다.")
    @ParameterizedTest
    @CsvSource(value = {"5000,8,62.5", "10000,1,1000.0", "15000,9,166.7"})
    void calculateProfit(int priceSum, int lottoCount, String expected) {
        String profit = ProfitCalculator.calculate(priceSum, lottoCount);

        assertThat(profit).isEqualTo(expected);
    }

    @DisplayName("로또 구입 갯수가 0이면 예외를 발생시킨다.")
    @Test
    void calculateProfitByZeroLottoCount() {
        assertThatThrownBy(() -> ProfitCalculator.calculate(10000, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 로또를 구매해야 수익률을 계산할 수 있습니다.");
    }
}
