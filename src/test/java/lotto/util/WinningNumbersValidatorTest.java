package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumbersValidatorTest {
    private final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();

    @DisplayName("올바른 값을 입력할 시 정상 동작")
    @Test
    void testValidateWinningNumbersWithValidInput() {
        List<String> validNumbers = List.of("1", "2", "3", "4", "5", "6");
        assertDoesNotThrow(() -> winningNumbersValidator.validateWinningNumbers(validNumbers));
    }

    @DisplayName("올바르지 않은 값을 입력했을때 예외처리")
    @Test
    void testValidateWinningNumbersWithInvalidInput() {
        List<String> emptyNumbers = List.of();
        assertThrows(IllegalArgumentException.class, () -> winningNumbersValidator.validateWinningNumbers(emptyNumbers));

        List<String> nonNumericNumbers = List.of("1", "2", "abc", "4", "5", "6");
        assertThrows(IllegalArgumentException.class, () -> winningNumbersValidator.validateWinningNumbers(nonNumericNumbers));

        List<String> notSixNumbers = List.of("1", "2", "3", "4", "5");
        assertThrows(IllegalArgumentException.class, () -> winningNumbersValidator.validateWinningNumbers(notSixNumbers));

        List<String> duplicateNumbers = List.of("1", "2", "3", "4", "2", "6");
        assertThrows(IllegalArgumentException.class, () -> winningNumbersValidator.validateWinningNumbers(duplicateNumbers));

        List<String> outOfRangeNumbers = List.of("1", "2", "3", "4", "5", "50");
        assertThrows(IllegalArgumentException.class, () -> winningNumbersValidator.validateWinningNumbers(outOfRangeNumbers));
    }
}