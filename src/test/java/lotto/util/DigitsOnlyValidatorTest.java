package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DigitsOnlyValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "123abc", "123한글", "12.34", "123 ", " 123", "1,000"})
    void 숫자가_아닌_문자열_입력시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> DigitsOnlyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "5000", "45"})
    void 숫자로만_이루어진_문자열_입력시_예외가_발생하지_않는다(String input) {
        assertDoesNotThrow(
                () -> DigitsOnlyValidator.validate(input)
        );
    }
}
