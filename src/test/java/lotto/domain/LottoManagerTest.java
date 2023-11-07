package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.prize.Prize;
import lotto.domain.prize.WinningDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateProfitRateTest() {
        int money = 8_000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(money);
        WinningDetails winningDetails = WinningDetails.createWinningDetails();
        winningDetails.increasePrizeAmount(Prize.FIFTH_PLACE);
        LottoManager lottoManager = LottoManager.from(winningDetails);
        double expectedRate = 62.5;

        double profitRate = lottoManager.calculateProfitRate(purchaseAmount);

        assertThat(profitRate).isEqualTo(expectedRate);
    }
}