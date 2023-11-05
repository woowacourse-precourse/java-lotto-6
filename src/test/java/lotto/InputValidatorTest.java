package lotto;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("쉽표 없이 입력할 경우 예외가 발생한다.")
    void readInputNotContainDelimiter() {
        String input = "1 2 3 4 5 6";
        assertThatThrownBy(() -> validator.validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 입력될 경우 예외가 발생한다.")
    void readNotInteger() {
        String input = "hi";
        assertThatThrownBy(() -> validator.validateDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
