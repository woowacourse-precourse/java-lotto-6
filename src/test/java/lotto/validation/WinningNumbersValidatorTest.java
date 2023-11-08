package lotto.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    @Test
    @DisplayName("올바른 당첨 번호와 보너스 번호 검증")
    void validateCorrectNumbersAndBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        assertDoesNotThrow(() -> WinningNumbersValidator.validate(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("잘못된 숫자 개수를 가진 당첨 번호 검증")
    void validateIncorrectNumberCount() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);
        int bonusNumber = 7;
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("중복된 숫자가 있는 당첨 번호 검증")
    void validateDuplicateNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        int bonusNumber = 7;
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("범위를 벗어난 숫자가 있는 당첨 번호 검증")
    void validateNumbersOutOfRange() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 50);
        int bonusNumber = 7;
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호 리스트에 포함된 경우 검증")
    void validateBonusNumberInWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validate(winningNumbers, bonusNumber));
    }
}