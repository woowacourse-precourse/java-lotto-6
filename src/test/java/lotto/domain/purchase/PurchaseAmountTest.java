package lotto.domain.purchase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("로또 구입 금액이 1,000원부터 100,000원 사이가 아니라면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByInvalidRange() {
        assertThatThrownBy(() -> new PurchaseAmount(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new PurchaseAmount(200_000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByInvalidDividend() {
        assertThatThrownBy(() -> new PurchaseAmount(1_001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculatePurchaseQuantity() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(10_000);

        int purchaseQuantity = purchaseAmount.calculatePurchaseQuantity();

        assertThat(purchaseQuantity).isEqualTo(10);
    }
}