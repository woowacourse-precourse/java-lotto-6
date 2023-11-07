package lotto.domain;

import static lotto.settings.ErrorMessage.INVALID_UNIT_FORMAT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    @DisplayName("구입 금액은 1000원 단위여야 정상적으로 저장된다.")
    void createCorrect() {
        PurchaseAmount purchaseAmount = PurchaseAmount.from(3000);
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    void validateUnits() {
        assertThatThrownBy(()->PurchaseAmount.from(1002))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIT_FORMAT.getMessage());

        assertThatThrownBy(()->PurchaseAmount.from(100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_UNIT_FORMAT.getMessage());
    }
}