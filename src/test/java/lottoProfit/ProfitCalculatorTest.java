package lottoProfit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    private ProfitCalculator profitCalculator;

    @DisplayName("숫자를 넣으면 둘째자리에서 반올림한 값을 반환한다.")
    @Test
    void roundToTwoDecimalPlaces() {
        profitCalculator = new ProfitCalculator();
        double result = profitCalculator.roundUpProfit(3000000, 20000000);
        assertThat(result).isEqualTo(15);
    }
}