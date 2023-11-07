package lotto.domain;

import static lotto.domain.constant.LottoPrizeConstant.FIRST_PRIZE_COUNT;
import static lotto.domain.constant.LottoPrizeConstant.SECOND_PRIZE_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitTest {

    private LottoProfit lottoProfit;
    private LottoPrize lottoPrize;

    @BeforeEach
    void initLottoProfit() {
        lottoProfit = LottoProfit.create();
        lottoPrize = LottoPrize.create();
    }

    @Test
    @DisplayName("로또 당첨 내역을 기반하여 총 당첨액을 올바르게 계산 하는지 테스트")
    void testTotalWinningAmountEqualsExpectedValue() {
        boolean hasBonusNumber = true;
        int secondRankCount = SECOND_PRIZE_COUNT.getNumber();
        int firstRankCount = FIRST_PRIZE_COUNT.getNumber();
        lottoPrize.updateRankCount(secondRankCount, hasBonusNumber);
        lottoPrize.updateRankCount(firstRankCount, hasBonusNumber);
        LottoPurchase lottoPurchase = LottoPurchase.create(8);
        lottoProfit.createLottoProfit(lottoPrize, lottoPurchase);

        int totalWinningAmount = lottoProfit.createTotalWinningAmount(lottoPrize);

        assertThat(totalWinningAmount).isEqualTo(2030000000);
    }
}