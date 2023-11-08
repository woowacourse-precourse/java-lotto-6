package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    @DisplayName("로또 구입 금액이 0원일 경우 예외가 발생한다.")
    @Test
    void purchasedAmountIsZero() {
        assertThatThrownBy(() -> PurchaseAmount.validate(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void purchasedAmountIsMinus() {
        assertThatThrownBy(() -> PurchaseAmount.validate(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1020", "9999"})
    @DisplayName("로또 구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    void inputWrongPurchaseAmount(int amount) {
        assertThatThrownBy(() -> PurchaseAmount.validate(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
