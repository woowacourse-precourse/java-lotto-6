package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
    @DisplayName("보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
    @Test
    void createPurchaseByNotDivisible() {
        assertThatThrownBy(() -> new Purchase(14500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 0이면 예외가 발생한다.")
    @Test
    void createPurchaseByZero() {
        assertThatThrownBy(() -> new Purchase(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 음수면 예외가 발생한다.")
    @Test
    void createPurchaseByNegative() {
        assertThatThrownBy(() -> new Purchase(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
