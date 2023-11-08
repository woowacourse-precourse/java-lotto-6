package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void testInvalidLottoPurchaseAmount() {
        assertThatThrownBy(() -> new Purchase(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 미만인 경우 예외가 발생한다.")
    @Test
    void testPurchaseAmountBelow1000() {
        assertThatThrownBy(() -> new Purchase(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}