package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchasedLottosTest {
    @Test
    @DisplayName("구입 금액에 맞는 로또의 개수가 반환되어야 한다.")
    void correctNumberOfLottosForAmountTest() {
        // Given
        String amount = "6000";

        // When
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        PurchasedLottos purchasedLottos = new PurchasedLottos(purchaseAmount);
        List<Lotto> lottos = purchasedLottos.getLottos();

        // Then
        assertThat(lottos.size()).isEqualTo(6);
    }
}
