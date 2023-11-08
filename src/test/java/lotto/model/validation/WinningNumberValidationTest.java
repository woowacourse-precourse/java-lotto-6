package lotto.model.validation;

import lotto.view.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class WinningNumberValidationTest {

    @DisplayName("당첨 번호의 수가 유효하지 않으면 예외 발생")
    @Test
    void whenWinningNumbersCountIsInvalid_thenThrowException() {
        String invalidCountNumbers = "1, 2, 3, 4, 5";

        assertThatThrownBy(() -> WinningNumberValidation.validateWinningNumbers(invalidCountNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_NUMBER_COUNT.getMessage());
    }

    @DisplayName("당첨 번호가 범위를 벗어나면 예외 발생")
    @Test
    void whenWinningNumberIsOutOfRange_thenThrowException() {
        String outOfRangeNumbers = "1, 2, 3, 4, 5, 60";

        assertThatThrownBy(() -> WinningNumberValidation.validateWinningNumbers(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_IN_RANGE_ERROR.getMessage());
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외 발생")
    @Test
    void whenWinningNumbersHaveDuplicates_thenThrowException() {
        String duplicateNumbers = "1, 2, 3, 4, 4, 5";

        assertThatThrownBy(() -> WinningNumberValidation.validateWinningNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("당첨 번호가 유효할 때 예외 없음")
    @Test
    void whenWinningNumbersAreValid_thenNoException() {
        String validNumbers = "1, 2, 3, 4, 5, 6";

        List<Integer> result = WinningNumberValidation.validateWinningNumbers(validNumbers);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
