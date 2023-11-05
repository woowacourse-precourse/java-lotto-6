package lotto.domain.profit;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.prize.LottoPrizeType;
import lotto.domain.result.LottoGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitRateCalculatorTest {

    @DisplayName("구입 금액과 당첨 내역을 바탕으로 수익률을 계산할 수 있다.")
    @Test
    void calculate() {
        // given
        LottoPurchaseAmount purchaseAmount = new LottoPurchaseAmount(BigDecimal.valueOf(5000L));
        LottoGameResult gameResult = new LottoGameResult(
                Map.of(
                        LottoPrizeType.FIRST, 0,
                        LottoPrizeType.SECOND, 0,
                        LottoPrizeType.THIRD, 0,
                        LottoPrizeType.FOURTH, 1,
                        LottoPrizeType.FIFTH, 2
                )
        );

        LottoProfitRateCalculator calculator = new LottoProfitRateCalculator();

        // when
        LottoProfitRate result = calculator.calculate(purchaseAmount, gameResult);

        // then
        assertThat(result.getRate()).isEqualTo(BigDecimal.valueOf(1200L));
    }

}