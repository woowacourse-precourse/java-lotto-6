package lotto.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    void validate_빈문자열받으면_예외를_반환한다() {
        String empty = "";
        assertThatThrownBy(() -> InputValidator.validate(empty))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void validate_null받으면_예외를_반환한다() {
        assertThatThrownBy(() -> InputValidator.validate(null))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"  ", " ", "            "})
    void validate_공백문자열_받으면_예외를_반환한다(String blank) {
        assertThatThrownBy(() -> InputValidator.validate(blank))
                .isInstanceOf(IllegalArgumentException.class);
    }

}