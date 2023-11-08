package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommaSeparatedNumbersValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {",", "123,", ",123", " ", "", "12a,3", "23 ,45"})
    void 숫자와_콤마로_이루어지지_않은_문자열_입력시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> CommaSeparatedNumbersValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "23"})
    void 숫자와_콤마로_이루어진_문자열_입력시_예외가_발생하지_않는다(String input) {
        assertDoesNotThrow(
                () -> CommaSeparatedNumbersValidator.validate(input)
        );
    }
}
