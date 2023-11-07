package lotto.domain.profit;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.result.TotalPrizeAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitRateCalculatorTest {

    @DisplayName("구입 금액과 당첨 금액을 바탕으로 수익금을 계산할 수 있다.")
    @Test
    void calculate() {
        // given
        LottoProfitRateCalculator calculator = new LottoProfitRateCalculator();
        LottoPurchaseAmount purchaseAmount = new LottoPurchaseAmount(new BigDecimal(8000));
        TotalPrizeAmount prizeAmount = new TotalPrizeAmount(new BigDecimal(5000));

        // when
        LottoProfitRate profitRate = calculator.calculate(purchaseAmount, prizeAmount);

        // then
        assertThat(profitRate.getRate().doubleValue())
                .isEqualTo(62.5);
    }

}