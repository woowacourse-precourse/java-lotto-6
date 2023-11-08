package lotto.domain;

import static lotto.domain.constant.LottoPrizeConstant.FIRST_PRIZE_COUNT;
import static lotto.domain.constant.LottoPrizeConstant.FIFTH_PRIZE_COUNT;
import static lotto.domain.constant.LottoPrizeConstant.SECOND_PRIZE_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoProfitTest {

    private LottoProfit lottoProfit;
    private LottoPrize lottoPrize;

    @BeforeEach
    void initLottoProfit() {
        lottoProfit = LottoProfit.create();
        lottoPrize = LottoPrize.create();
    }

    @Nested
    @DisplayName("총 당첨액과 총 구입 금액이 올바르게 계산이 되는지 테스트")
    class testTotalWinningsAndTotalPurchaseAmount {
        @Test
        @DisplayName("로또 당첨 내역에 기반하여 로또 총 당첨액이 예상값과 일치하는지 테스트")
        void testTotalWinningAmountEqualsExpectedValue() {
            boolean hasBonusNumber = true;
            int secondRankCount = SECOND_PRIZE_COUNT.getNumber();
            int firstRankCount = FIRST_PRIZE_COUNT.getNumber();
            lottoPrize.updateRankCount(secondRankCount, hasBonusNumber);
            lottoPrize.updateRankCount(firstRankCount, hasBonusNumber);

            int totalWinningAmount = lottoProfit.createTotalWinningAmount(lottoPrize);

            assertThat(totalWinningAmount).isEqualTo(2030000000);
        }

        @Test
        @DisplayName("로또 구매 개수에 기반하여 로또 총 구입 금액이 예상값과 일치하는지 테스트")
        void testLottoPurchaseTotalAmountEqualsExpectedValue() {
            LottoPurchase lottoPurchase = LottoPurchase.create(23);

            int totalPurchaseAmount = lottoProfit.createTotalPurchaseAmount(lottoPurchase);

            assertThat(totalPurchaseAmount).isEqualTo(23000);
        }
    }

    @Test
    @DisplayName("당첨 수익률이 예상값과 일치하는지 테스트")
    void testProfitRateEqualsExpectedValue() {
        boolean hasBonusNumber = true;
        int fifthRankCount = FIFTH_PRIZE_COUNT.getNumber();
        lottoPrize.updateRankCount(fifthRankCount, hasBonusNumber);
        LottoPurchase lottoPurchase = LottoPurchase.create(8);

        lottoProfit.updateLottoProfit(lottoPrize, lottoPurchase);

        assertThat(lottoProfit.getTotalProfitRate().getProfitRate()).isEqualTo(62.5);
    }
}