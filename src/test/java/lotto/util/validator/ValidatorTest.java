package lotto.util.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("입력 받은 문자가 숫자인지 검증한다.")
    @Test
    void validateNumeric() {
        // given
        String input = "100";

        // when, then
        assertThatCode(() -> Validator.validateNumeric(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력 받은 문자가 숫자가 아니면 예외를 발생시킨다.")
    @Test
    void validateNotNumeric() {
        // given
        String input = "abc";

        // when, then
        assertThatThrownBy(() -> Validator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}