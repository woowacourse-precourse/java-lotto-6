package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitCalculatorTest {

    @Test
    void calculate() {
        ProfitCalculator calculator = new ProfitCalculator(8000,5000);
        assertThat(calculator.calculate()).isEqualTo("62.5");
    }
}