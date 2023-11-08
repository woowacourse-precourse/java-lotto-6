package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @DisplayName("입력 받은 값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void testNonNumericInput() {
        Validator validator = new Validator();
        assertThatThrownBy(()-> validator.validateInput("일"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 값이 빈 값이면 예외가 발생한다.")
    @Test
    void testEmptyInput() {
        Validator validator = new Validator();
        assertThatThrownBy(()-> validator.validateInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}