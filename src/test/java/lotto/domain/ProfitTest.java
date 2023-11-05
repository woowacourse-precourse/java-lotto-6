package lotto.domain;

import lotto.util.WinnerRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {
    private Profit profit = new Profit();
    private final PurchasePrice purchasePrice;
    private final WinResult winResult;

    private ProfitTest() {
        int price = 7000;
        this.purchasePrice = new PurchasePrice(price);
        this.winResult = new WinResult();
    }

    @DisplayName("수익률 계산 확인")
    @Test
    void calculateProfitRate() {
        winResult.increaseWinResultValue(WinnerRank.FOUR.getValue());//four
        winResult.increaseWinResultValue(WinnerRank.FIVE_WITHOUT_BOUNUS.getValue());

        assertThat(profit.calculateProfitRate(purchasePrice, winResult)).isEqualTo(22142.86);
    }
}
