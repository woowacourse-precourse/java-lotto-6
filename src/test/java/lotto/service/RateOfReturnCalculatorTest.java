package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RateOfReturnCalculatorTest {

    @Test
    void 소숫점_두번째_자리에서_반올림한_올바른_수익률을_내는지_확인() {
        // Given
        int amount = 10000;
        int finalPrize = 5000;

        // When
        double rateOfReturn = RateOfReturnCalculator.calculateRateOfReturn(amount, finalPrize);

        // Then
        assertThat(rateOfReturn).isEqualTo(50.0);
    }

    @Test
    void 구입금액이_올바르지_않을_때_오류처리를_하는지_확인() {
        // Given
        int amount = 0;
        int finalPrize = 5000;

        // When, Then
        assertThatThrownBy(() -> RateOfReturnCalculator.calculateRateOfReturn(amount, finalPrize))
                .isInstanceOf(ArithmeticException.class);
    }
}