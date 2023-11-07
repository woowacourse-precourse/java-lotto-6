package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {

    @Test
    @DisplayName("당첨 번호를 유효성 검사")
    void validateWinningNumbers() {
        // 유효한 당첨 번호인 경우
        String validInput = "6,15,20,27,37,42";
        assertDoesNotThrow(() -> WinningNumbersValidator.validateWinningNumbers(validInput));

        // 6개의 숫자가 아닌 경우
        String invalidLengthInput = "1,2,3,4,5";
        IllegalArgumentException invalidLengthException = assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validateWinningNumbers(invalidLengthInput));
        assertEquals("[ERROR] 6개의 숫자를 입력해 주세요.", invalidLengthException.getMessage());

        // 1부터 45 사이의 숫자가 아닌 경우
        String invalidRangeInput = "1,2,3,4,5,46";
        IllegalArgumentException invalidRangeException = assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validateWinningNumbers(invalidRangeInput));
        assertEquals("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.", invalidRangeException.getMessage());

        // 중복된 숫자가 있는 경우
        String invalidDuplicateInput = "1,2,3,4,4,5";
        IllegalArgumentException invalidDuplicateException = assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validateWinningNumbers(invalidDuplicateInput));
        assertEquals("[ERROR] 중복되지 않는 숫자 6개를 입력해 주세요.", invalidDuplicateException.getMessage());
    }
}
