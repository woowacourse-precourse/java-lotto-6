package lotto.domain.prize.statistics;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.lotto.LottoPurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수익률 도메인")
class EarningRateTest {
    @Test
    @DisplayName("수익률은 총 탕첨 금액에 로또 구입 금액을 나눈 값입니다.")
    void Should_TotalPrizeAmount_Divided_By_PurchasingAmount_When_Get_Earning_Rate() {
        //given
        final TotalPrizeAmount totalPrizeAmount = new TotalPrizeAmount(20_000);
        final LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(50_000);
        final double expected = (double) totalPrizeAmount.getAmount() / lottoPurchaseAmount.getAmount();

        //when
        final EarningRate earningRate = new EarningRate(
                lottoPurchaseAmount,
                totalPrizeAmount
        );
        final double actual = earningRate.getEarningRate();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
