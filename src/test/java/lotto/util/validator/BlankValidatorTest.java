package lotto.util.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BlankValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "12", "012"})
    void 공백이_없다(String value) {
        assertDoesNotThrow(() -> BlankValidator.validate(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 공백이_있다면_예외를_발생시킨다(String value) {
        assertThatThrownBy(() -> BlankValidator.validate(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백 문자는 입력할 수 없습니다.");
    }
}