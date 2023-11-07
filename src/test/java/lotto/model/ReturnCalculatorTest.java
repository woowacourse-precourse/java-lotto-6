package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReturnCalculatorTest {
    @DisplayName("수익률은 백분율로 소수 둘째자리에서 반올림한다. - 0.2579이면 25.8")
    @Test
    void testCalculateRateOfReturn() {
        ReturnCalculator returnCalculator = new ReturnCalculator();

        double rateOfReturn = returnCalculator.calculateRateOfReturn(0.2579);

        assertThat(rateOfReturn).isEqualTo(25.8);
    }
}
