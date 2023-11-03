package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseValidationExceptionTest {

    @Test
    @DisplayName("숫자가 아닌 입력에 대해 PurchaseValidationException 예외 발생")
    void whenInputIsNotNumeric_thenThrowPurchaseValidationException() {
        String nonNumericInput = "abc";
        assertThrows(PurchaseValidationException.class, () ->
                PurchaseValidationException.checkIsNumeric(nonNumericInput));
    }

}