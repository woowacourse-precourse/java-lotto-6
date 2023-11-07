package lotto.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    @DisplayName("구입 금액으로 로또 구입 개수를 구한다.")
    void getLottoCount_LottoPrice() {
        // Given
        final int purchasePrice = 8_000;

        // When
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchasePrice);

        // Then
        assertThat(purchaseAmount.getAmount()).isEqualTo(purchasePrice / 1_000);
    }

}