package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("입력값으로 문자가 입력되면 예외가 발생한다.")
    @Test
    void isNotDigitTest1() {
        String input = "string";
        assertThatThrownBy(() -> inputValidator.validateIsDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값에 문자가 포함되면 예외가 발생한다.")
    @Test
    void isNotDigitTest2() {
        String input = "5000j";
        assertThatThrownBy(() -> inputValidator.validateIsDigit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}