package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = { "6,15,20,27,37,42", "10,11,12,13,14,15", "1,2,3,4,5,6" })
    @DisplayName("유효한 당첨 번호 입력인 경우")
    void validateValidWinningNumbers(String input) {
        assertDoesNotThrow(() -> WinningNumbersValidator.validateWinningNumbers(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,46" })
    @DisplayName("유효하지 않은 당첨 번호 입력인 경우 - 예외 발생")
    void validateInvalidWinningNumbers(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> WinningNumbersValidator.validateWinningNumbers(input));

        if (input.split(",").length != 6) {
            assertEquals("[ERROR] 6개의 숫자를 입력해 주세요.", exception.getMessage());
        } else if (input.matches("1,1,2,3,4,5")) {
            assertEquals("[ERROR] 중복되지 않는 숫자 6개를 입력해 주세요.", exception.getMessage());
        } else {
            assertEquals("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.", exception.getMessage());
        }
    }
}
