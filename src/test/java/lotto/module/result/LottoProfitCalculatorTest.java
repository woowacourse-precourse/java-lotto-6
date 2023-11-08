package lotto.module.result;

import lotto.module.domain.LottoProfit;
import lotto.module.domain.PurchaseAmount;
import lotto.module.domain.TotalPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.within;

class LottoProfitCalculatorTest {
    private final LottoProfitCalculator lottoProfitCalculator = LottoProfitCalculator.newInstance();

    @Test
    void 수익률_계산_성공_테스트() {
        // given
        double expectedRate = 83.3;
        PurchaseAmount purchaseAmount = PurchaseAmount.newInstance(12000);
        TotalPrize totalPrize = new TotalPrize(10000);

        // when
        LottoProfit profitRate = lottoProfitCalculator.getProfitRate(purchaseAmount, totalPrize);

        // then
        Assertions.assertThat(profitRate.rate())
                .isCloseTo(expectedRate, within(0.1));
    }

}