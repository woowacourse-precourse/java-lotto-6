package lotto;

import lotto.model.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 빈 경우 예외가 발생한다.")
    @Test
    void PurchaseAmountIsEmpty() {
        assertThatThrownBy(() -> PurchaseAmount.empty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void PurchaseAmountIsNotNumber(){
        assertThatThrownBy(() -> PurchaseAmount.notNumber("80c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음수인 경우 예외가 발생한다.")
    @Test
    void PurchaseAmountIsNegative(){
        assertThatThrownBy(() -> PurchaseAmount.negativeNumber(-80))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
