package lotto.utils;

import static lotto.enums.ExceptionMessageType.INVALID_SEPARATOR_OR_NUMBER_COUNT;
import static lotto.enums.ExceptionMessageType.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersValidatorTest {

    @DisplayName("쉼표(,)로 구분된 6개 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2abc,3,4,5,6", "1,2,,3,4,5", "1,2,3", "1,2,3,4,5,6,7"})
    void testValidateSeparator(String numbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateSeparator(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_SEPARATOR_OR_NUMBER_COUNT.getMessage());
    }

    @DisplayName("번호는 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -20})
    void testValidateRange(int numbers) {
        assertThatThrownBy(() -> WinningNumbersValidator.validateRange(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OUT_OF_RANGE.getMessage());
    }
}