package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersValidatorTest {

    @DisplayName("당첨 번호 유효성 검증")
    @Test
    void validateWinningNumbers() {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when, then
        assertThatCode(() -> WinningNumbersValidator.validate(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void validateNotNumeric() {
        // given
        String input = "a, b, c, d, e, f";

        // when, then
        assertThatThrownBy(() -> WinningNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void validate() {
        // given
        String input = "0, 1, 2, 3, 4, 45";

        // when, then
        assertThatThrownBy(() -> WinningNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}