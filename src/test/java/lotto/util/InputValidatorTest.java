package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
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
    void validatePositiveNumberTest() {
        String negativeNumber = "-5";

        assertThatThrownBy(() -> InputValidator.validatePositiveNumber(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validatePositiveNumber() {
    }

    @DisplayName("입력값이 비어있을때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void validateEmptyInputTest(String input) {
        assertThatThrownBy(() -> InputValidator.validateEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}