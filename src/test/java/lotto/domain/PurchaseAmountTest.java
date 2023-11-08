package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @DisplayName("1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createPurChaseAmountBy1500() {
        assertThatThrownBy(() -> PurchaseAmount.create(1500)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원 이라면  예외가 발생한다.")
    @Test
    void createPurChaseAmountByZero() {
        assertThatThrownBy(() -> PurchaseAmount.create(1500)).isInstanceOf(IllegalArgumentException.class);
    }
}
