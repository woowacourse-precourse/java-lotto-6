package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DigitsOnlyValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "12", "012"})
    void 정수이다(String value) {
        assertDoesNotThrow(() -> DigitsOnlyValidator.validate(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a12", " 12", "12 3"})
    void 정수가_아닌_경우_예외를_발생시킨다(String value) {
        assertThatThrownBy(() -> DigitsOnlyValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수만 입력 가능합니다.");
    }
}