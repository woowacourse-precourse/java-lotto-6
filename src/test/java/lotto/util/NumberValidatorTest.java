package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    private final NumberValidator numberValidator = new NumberValidator();

    @DisplayName("올바른 값을 입력할 시 정상 동작")
    @Test
    void testValidatePurchaseAmountWithValidInput() {
        assertDoesNotThrow(() -> numberValidator.validatePurchaseAmount("5000"));
    }

    @DisplayName("올바르지 않은 값을 입력했을때 예외처리")
    @Test
    void testValidatePurchaseAmountWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePurchaseAmount(""));

        assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePurchaseAmount("abc"));

        assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePurchaseAmount("2147483648"));

        assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePurchaseAmount("0"));

        assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePurchaseAmount("-1000"));

        assertThrows(IllegalArgumentException.class, () -> numberValidator.validatePurchaseAmount("1500"));
    }

    @DisplayName("올바른 값을 입력할 시 정상 동작")
    @Test
    void testValidateBonusNumberWithValidInput() {
        assertDoesNotThrow(() -> numberValidator.validateBonusNumber("7"));
    }

    @DisplayName("올바르지 않은 값을 입력했을때 예외처리")
    @Test
    void testValidateBonusNumberWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> numberValidator.validateBonusNumber(""));

        assertThrows(IllegalArgumentException.class, () -> numberValidator.validateBonusNumber("abc"));

        assertThrows(IllegalArgumentException.class, () -> numberValidator.validateBonusNumber("46"));
    }
}