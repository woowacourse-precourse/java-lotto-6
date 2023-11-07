package lotto.domain;

import lotto.util.WinnerRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateTest {
    private ProfitRate profitRate = new ProfitRate();
    private final PurchasePrice purchasePrice;
    private final WinResult winResult;

    private ProfitRateTest() {
        int price = 7000;
        this.purchasePrice = new PurchasePrice(price);
        this.winResult = new WinResult();
    }

    @DisplayName("수익률 계산 확인")
    @Test
    void calculateProfitRate() {
        String expectedProfitRate = "22142.86";

        winResult.increaseWinResultValue(WinnerRank.FOUR.getRankKey());
        winResult.increaseWinResultValue(WinnerRank.FIVE_WITHOUT_BOUNUS.getRankKey());

        assertThat(profitRate.calculateProfitRate(purchasePrice, winResult)).isEqualTo(expectedProfitRate);
    }
}
