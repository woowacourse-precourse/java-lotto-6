package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {

    @DisplayName("문자가 포함된 구입 금액이 있으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNotNumber() {
        assertThatThrownBy(() -> new Purchase("500o0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1,000원으로 나누어 떨어지지 않는 금액이 있으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByIndivisible() {
        assertThatThrownBy(() -> new Purchase("4002"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원이 입력된 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByZero() {
        assertThatThrownBy(() -> new Purchase("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
