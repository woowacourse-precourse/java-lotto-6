package lotto.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    @DisplayName("숫자가 아닌 입력이 들어오면 예외가 발생한다.")
    void testInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber("ab"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber("0.1"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber("1 2"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber(""));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber(" "));
    }

    @Test
    @DisplayName("숫자인 입력이 들어오면 예외가 발생하지 않는다.")
    void testValidNumber() {
        assertDoesNotThrow(() -> InputValidator.validateIsNumber("123"));
        assertDoesNotThrow(() -> InputValidator.validateIsNumber("0"));
        assertDoesNotThrow(() -> InputValidator.validateIsNumber("-456"));
    }

    @Test
    @DisplayName("입력 중에 숫자가 아닌 값이 하나라도 있으면 예외를 발생시킨다.")
    void testInvalidNumbers(){
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateIsNumber(""));

    }
}