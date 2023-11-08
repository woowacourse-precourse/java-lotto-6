package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @DisplayName("수가 아닌 문자열이 들어갔을 때, 예외")
    @Test
    void validateOrderTest_noneDigit() {
        assertThatThrownBy(() -> InputValidator.validateOrderPrice("8000k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateOrderTest_cantDivide1000() {
        assertThatThrownBy(() -> InputValidator.validateOrderPrice("8700"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}