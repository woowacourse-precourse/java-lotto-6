package lotto.util.validator;

import lotto.util.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberValidatorTest {
    @Test
    @DisplayName("당첨 번호 문자열을 유효하게 파싱하여 List<Integer>를 반환한다.")
    void validateWinningNumbers() {
        String inputWinningNumbers = "1, 2, 3, 4, 5, 6";

        assertThat(WinningNumberValidator.validateWinningNumbers(inputWinningNumbers))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 문자열에 null이나 빈 문자열이 들어올 경우 예외를 던진다.")
    void validateWinningNumbersWithNullOrEmpty() {
        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_WINNING_NUMBERS.getMessage());

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_WINNING_NUMBERS.getMessage());

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY_WINNING_NUMBERS.getMessage());
    }


    @Test
    @DisplayName("당첨 번호 문자열의 개수가 6개가 아닌 경우 예외를 던진다.")
    void validateWinningNumbersWithInvalidCount() {
        String inputWinningNumbers = "1, 2, 3, 4, 5";

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 문자열의 형식이 잘못된 경우 예외를 던진다.")
    void validateWinningNumbersWithInvalidFormat() {
        String inputWinningNumbers = "1, 2, 3, 4, a, 6";

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호 범위가 1부터 45를 벗어난 경우 예외를 던진다.")
    void validateWinningNumbersWithInvalidRange() {
        String inputWinningNumbers = "0, 2, 3, 4, 5, 46";

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_WINNING_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있는 경우 예외를 던진다.")
    void validateWinningNumbersWithDuplicateNumbers() {
        String inputWinningNumbers = "1, 2, 3, 4, 4, 6";

        assertThatThrownBy(() -> WinningNumberValidator.validateWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATE_WINNING_NUMBERS.getMessage());
    }
}