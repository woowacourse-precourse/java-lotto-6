package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("사용자 입력 값을 쉼표로 구분하여 숫자 문자열을 입력하지 않으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c,d", "1|2|3|4|5|6", "1,,25,,45,,67", "1,5,78,45,"})
    void should_Throw_Exception_For_Non_Comma_Separated_Numeric_Input(String input) {
        // when
        // then
        assertThatThrownBy(() -> InputValidator.verifyValidaNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("쉼표 구분하여 숫자만 입력해주세요.");
    }

    @DisplayName("사용자 입력 값이 공백, 길이가 0, null이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullSource
    void should_Throw_Exception_For_Null_Or_Blank_Input(String input) {
        // when
        // then
        assertThatThrownBy(() -> InputValidator.verifyNonEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 비어있습니다.");
    }

    @DisplayName("사용자 입력 값이 숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"!!", "*", "q", "#88", "c9", "f4^"})
    void should_Throw_Exception_For_Non_Numeric_Input(String input) {
        // when
        // then
        assertThatThrownBy(() -> InputValidator.verifyNumericString(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }
}