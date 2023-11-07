package lotto.validation;

import lotto.messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.validation.PurchaseAmountCheckValidator.*;
import static org.assertj.core.api.Assertions.*;


class PurchaseAmountCheckValidatorTest {

    @Test
    @DisplayName("정상 처리")
    void 정상_처리() {
        validatePurchaseAmount("1000");
        validatePurchaseAmount("2000");
        validatePurchaseAmount("14000");
        validatePurchaseAmount("20000");
    }

    @Test
    @DisplayName("금액이 1,000원 단위가 아닐 때 예외")
    void 금액_비정상_예외() {
        assertThatThrownBy(() -> validatePurchaseAmount("14400"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INCORRECT_PURCHASE_AMOUNT);
    }
}