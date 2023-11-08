package lotto.util;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    @DisplayName("입력값이 숫자가 아닐때 예외처리 테스트")
    @Test
    void validateNumericTest() {
        String input = "test";

        assertThatThrownBy(() -> InputValidator.validatePositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 음수일 때 예외처리 테스트")
    @Test
    void validatePositiveNumberThrowExceptionTest() {
        String negativeNumber = "-5";

        assertThatThrownBy(() -> InputValidator.validatePositiveNumber(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 양수일 때 예외처리 테스트")
    @Test
    void validatePositiveNumberDoesNotThrowExceptionTest() {
        String negativeNumber = "5";

        assertThatCode(() -> InputValidator.validatePositiveNumber(negativeNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력값이 비어있을때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateEmptyInputThrowExceptionTest(String input) {
        assertThatThrownBy(() -> InputValidator.validateEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 비어있지 않을때 예외처리 테스트")
    @Test
    void validateEmptyInputDoesNotThrowExceptionTest() {
        String input = "test";

        assertThatCode(() -> InputValidator.validateEmptyInput(input))
                .doesNotThrowAnyException();
    }
}