package lotto.global.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.global.constant.message.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a1d", "12Aawv"})
    void 입력_값이_정수_형태가_아니면_예외를_발생한다(String value) {
        assertThatThrownBy(() -> Validator.validateIntFormat(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INT_FORMAT_ERROR.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void 입력_값이_공백이면_예외를_발생한다(String value) {
        assertThatThrownBy(() -> Validator.validateIntFormat(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INT_FORMAT_ERROR.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "58", "99"})
    void 입력_값이_정수_형태이면_예외가_발생하지_않는다(String value) {
        Validator.validateIntFormat(value);
    }
}
