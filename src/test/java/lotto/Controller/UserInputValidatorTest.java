package lotto.Controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserInputValidatorTest {

    @Test
    public void testValidatePurchaseAmountValid() {
        assertDoesNotThrow(() -> UserInputValidator.validatePurchaseAmount(1000));
    }

    @Test
    public void testValidatePurchaseAmountInvalid() {
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.validatePurchaseAmount(1050));
    }

    @Test
    public void testValidateBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> UserInputValidator.validateBonusNumber(winningNumbers, 7));
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.validateBonusNumber(winningNumbers, 6));
    }

    @Test
    public void testValidateLottoNumber() {
        assertDoesNotThrow(() -> UserInputValidator.validateLottoNumber(1));
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.validateLottoNumber(46));
    }

    @Test
    public void testValidateLottoNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 2, 4, 5, 6);
        assertDoesNotThrow(() -> UserInputValidator.validateLottoNumbers(validNumbers));
        assertThrows(IllegalArgumentException.class, () -> UserInputValidator.validateLottoNumbers(invalidNumbers));
    }

    // Further tests can be implemented here
}
