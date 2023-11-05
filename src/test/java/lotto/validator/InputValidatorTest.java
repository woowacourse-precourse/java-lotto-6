package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {
    @DisplayName("숫자가 아닌 입력이 주어지면 예외가 발생한다.")
    @Test
    void inputNotNumeric() {
        assertThatThrownBy(() -> InputValidator.validate("1000J"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 입력이 주어지면 예외가 발생한다.")
    @Test
    void inputEmpty() {
        assertThatThrownBy(() -> InputValidator.validate(""))
                .isInstanceOf(IllegalStateException.class);
    }
}
