package lotto;

import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 빈 경우 예외가 발생한다.")
    @Test
    void PurchaseAmountEmptyTEST() {
        assertThatThrownBy(() -> PurchaseAmount.empty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
