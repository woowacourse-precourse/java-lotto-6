package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    @Test
    @DisplayName("유효한 당첨 번호 검증")
    void testValidWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> WinningNumbersValidator.validate(winningNumbers));
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 예외 발생")
    void testInvalidNumberCount() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> WinningNumbersValidator.validate(winningNumbers));
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외 발생")
    void testDuplicateNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        assertThrows(IllegalArgumentException.class, () -> WinningNumbersValidator.validate(winningNumbers));
    }

    @Test
    @DisplayName("당첨 번호가 범위를 벗어날 경우 예외 발생")
    void testNumbersOutOfRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> WinningNumbersValidator.validate(winningNumbers));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void testDuplicateBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThrows(IllegalArgumentException.class, () -> WinningNumbersValidator.validateBonusNumber(bonusNumber, winningNumbers));
    }
}