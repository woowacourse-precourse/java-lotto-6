package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RateOfReturnCalculatorTest {

    @Test
    void calculate() {
        assertThat(RateOfReturnCalculator.calculate(1000, 100)).isEqualTo((double)1000.0);
        assertThat(Math.round(RateOfReturnCalculator.calculate(5000, 8000)))
                .isEqualTo(63);
    }
}