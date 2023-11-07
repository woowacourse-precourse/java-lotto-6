package view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.input.HasSpaceException;
import lotto.exception.input.NotIntegerException;
import lotto.exception.input.NullInputException;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {
    @DisplayName("입력이 공백일 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""," "})
    void inputNull(String input) {
        assertThatThrownBy(() -> InputValidator.validateInput(input))
                .isInstanceOf(NullInputException.class);
    }


}
