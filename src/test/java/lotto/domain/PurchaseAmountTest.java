package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @DisplayName("구입 금액에 해당하는 로또 개수를 확인한다.")
    @Test
    void createPurchaseQuantity() {
        assertThat(new PurchaseAmount("8000").getQuantity())
                .isEqualTo(8);
    }

    @DisplayName("구입 금액에 숫자가 아닌 문자가 있는 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNotNumber() {
        assertThatThrownBy(() -> new PurchaseAmount("100O"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createPurchaseAmountByDirtyNumber() {
        assertThatThrownBy(() -> new PurchaseAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
