package lotto.model;

import lotto.view.View.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static lotto.view.View.ERROR_PREFIX;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("양의 정수 입력을 검사한다")
    void testIsPositiveInteger() {
        assertDoesNotThrow(() -> Validator.isPositiveInteger("10"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.isPositiveInteger("-1"));
        assertEquals(ERROR_PREFIX + ErrorMessage.NOT_POSITIVE.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("구매 금액 입력을 검사한다")
    void testValidatePurchaseInput() {
        assertDoesNotThrow(() -> Validator.validatePurchaseInput("3000"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.validatePurchaseInput("2500"));
        assertTrue(exception.getMessage().contains(ERROR_PREFIX + ErrorMessage.BELOW_MINIMUM_AMOUNT.getMessage()));
    }

    @Test
    @DisplayName("당첨 번호 입력을 검사한다")
    void testValidateWinningNumbers() {
        assertDoesNotThrow(() -> Validator.validateWinningNumbers("1, 2, 3, 4, 5, 6"));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateWinningNumbers("1, 2, 3, 4, 5"));
        assertEquals(ERROR_PREFIX + ErrorMessage.INCORRECT_NUMBER_COUNT.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 번호 입력을 검사한다")
    void testValidateBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> Validator.validateBonusNumber(7, winningNumbers));
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateBonusNumber(6, winningNumbers));
        assertEquals(ERROR_PREFIX + ErrorMessage.DUPLICATE_NUMBER.getMessage(), exception.getMessage());
    }
}
