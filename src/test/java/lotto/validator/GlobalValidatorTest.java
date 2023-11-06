package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.validator.GlobalValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class GlobalValidatorTest {

    @Test
    @DisplayName("구입 금액 숫자인지 테스트")
    void purchaseAmountDigitTest() {
        //given
        String purchaseAmount = "12300aa";

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> validatePurchaseAmount(purchaseAmount));
    }
}