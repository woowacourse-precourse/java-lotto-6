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

    @Test
    @DisplayName("숫자 입력에 대해 예외가 발생하지 않음")
    void whenInputIsNumeric_thenDoesNotThrowException() {
        String numericInput = "12345";
        assertDoesNotThrow(() ->
                PurchaseValidationException.checkIsNumeric(numericInput));
    }

}