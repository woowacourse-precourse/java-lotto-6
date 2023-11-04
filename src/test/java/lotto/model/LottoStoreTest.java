package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    LottoStore lottoStore = new LottoStore();

    @DisplayName("1000원 당 1장의 로또를 발행해야 한다. - 3000원이면 3장")
    @Test
    void testThreeLottoIssueWhenThreeThousandWon() {
        int purchaseAmount = 3000;
        int purchasedLottoAmount = lottoStore.calculatePurchasedLottoAmount(purchaseAmount);

        assertThat(purchasedLottoAmount).isEqualTo(3);
    }

    @DisplayName("1000원 당 1장의 로또를 발행해야 한다. - 10000원이면 10장")
    @Test
    void testTenLottoIssueWhenTenThousandWon() {
        int purchaseAmount = 10000;
        int purchasedLottoAmount = lottoStore.calculatePurchasedLottoAmount(purchaseAmount);

        assertThat(purchasedLottoAmount).isEqualTo(10);
    }
}
