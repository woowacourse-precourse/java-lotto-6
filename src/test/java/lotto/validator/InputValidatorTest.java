package lotto.validator;

import static lotto.constants.ErrorCode.NOT_INTEGER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @ParameterizedTest(name = "입력 값: {0}")
    @DisplayName("입력한 값이 정수인지 여부를 확인하고, 정수가 아니라면 예외를 발생한다")
    @ValueSource(strings = {"1a", " ", "1 1"})
    public void should_throwException_when_gettingInput(String input) {
        assertThatThrownBy(() -> InputValidator.validateIsInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER.getMessage());
    }
}