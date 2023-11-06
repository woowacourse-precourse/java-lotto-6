package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 1000원보다 적은 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByUnderMinimumAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByIndivisibleNumber() {
        assertThatThrownBy(() -> new PurchaseAmount(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }
}