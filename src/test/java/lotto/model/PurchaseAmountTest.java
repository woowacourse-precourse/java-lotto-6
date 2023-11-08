package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseAmountTest {

    @Test
    void 천원_단위로_입력한_경우() {
        PurchaseAmount purchaseAmount = new PurchaseAmount();

        int games = purchaseAmount.convertAmountToGames("8000");

        assertThat(games).isEqualTo(8);
    }
}
