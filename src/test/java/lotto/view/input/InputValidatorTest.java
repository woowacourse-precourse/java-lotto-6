package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("입력값 숫차형태 테스트 : 입력값이 숫자형태가 아니라면 IllegalArgumentException를 발생시킨다.")
    @ParameterizedTest(name = "입력값이 \"{0}\" 이면 예외발생")
    @ValueSource(strings = {"100k", "abc", "123$"})
    void validateNumericFormat(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumericFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}