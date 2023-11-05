package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    void validateNumeric() {
    }

    @Test
    void validatePositiveNumber() {
    }

    @DisplayName("입력값이 비어있을때 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void validateEmptyInputTest(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}