package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ErrorType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("입력이 공백이면 예외를 발생시킨다.")
    void testInputNotBlank() {
        String input = " ";

        assertThatThrownBy(() ->inputValidator.validateBlank(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INPUT_NOT_BLANK.getMessage());
    }

    @Test
    @DisplayName("입력이 비어있으면 예외를 발생시킨다.")
    void testInputNotEmpty() {
        String input = "";

        assertThatThrownBy(() ->inputValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INPUT_NOT_EMPTY.getMessage());
    }

    @Test
    @DisplayName("입력이 숫자가 아니면 예외를 발생시킨다.")
    void testInputNotNumeric() {
        String input = "abc";

        assertThatThrownBy(() ->inputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INPUT_NOT_NUMERIC.getMessage());
    }
}