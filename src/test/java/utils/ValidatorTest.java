package utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @DisplayName("전달 받은 값에 문자가 포함되어있다면 예외를 발생")
    @Test
    void validateNumericInput() {
        assertThatThrownBy(() -> Validator.validateNumericValue("123a45"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값은 숫자로만 이루어져 있어야 합니다.");
    }

    @DisplayName("정상 값이 입력되어 예외를 발생하지 않음")
    @Test
    void validateNumericInputWithValidInput() {
        assertDoesNotThrow(() -> Validator.validateNumericValue("12345"));
    }

    @DisplayName("전달 받은 값이 비어있으면 예외를 발생")
    @Test
    void testValidateIsEmpty() {
        assertThatThrownBy(() -> Validator.validateIsEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 값이 없습니다.");
    }
}