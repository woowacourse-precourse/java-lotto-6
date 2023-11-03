package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseValidationExceptionTest {

    @Test
    @DisplayName("숫자가 아닌 입력에 대해 PurchaseValidationException 예외 발생")
    void throwsExceptionForNonNumericInput() {
        String nonNumericInput = "abc";
        assertThrows(PurchaseValidationException.class, () ->
                PurchaseValidationException.checkIsNumeric(nonNumericInput));
    }

    @Test
    @DisplayName("숫자 입력에 대해 예외가 발생하지 않음")
    void doesNotThrowExceptionForNumericInput() {
        String numericInput = "12345";
        assertDoesNotThrow(() ->
                PurchaseValidationException.checkIsNumeric(numericInput));
    }

    @Test
    @DisplayName("구매 금액이 로또 티켓 가격 단위의 배수가 아닐 때 PurchaseValidationException 예외 발생")
    void throwsExceptionForInvalidPurchaseAmount() {
        int invalidAmount = 1550; // 가정: LOTTO_TICKET_PRICE_UNIT가 1000이라고 할 때
        assertThrows(PurchaseValidationException.class, () ->
                PurchaseValidationException.checkValidPurchaseAmount(invalidAmount));
    }

    @Test
    @DisplayName("구매 금액이 로또 티켓 가격 단위의 배수일 때 예외가 발생하지 않음")
    void doesNotThrowExceptionForValidPurchaseAmount() {
        int validAmount = 2000; // 가정: LOTTO_TICKET_PRICE_UNIT가 1000이라고 할 때
        assertDoesNotThrow(() ->
                PurchaseValidationException.checkValidPurchaseAmount(validAmount));
    }
}