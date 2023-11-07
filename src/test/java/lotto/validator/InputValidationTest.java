package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.constants.Messages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {
    @DisplayName("문자열이 숫자형태가 아닐때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"asd", "as1", "3a3", "#43", "", " ", "  3", "$%@", "01000", "0012000"})
    void testInvalidNumericInput(String input) {
        assertThatThrownBy(() -> InputValidation.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_INVALID_NUMERIC_INPUT);
    }

    @DisplayName("문자열리스트중 하나라도 숫자형태가 아닐때 예외가 발생한다.")
    @Test
    void testInvalidNumericInputInList() {
        List<String> input = Arrays.asList("12", "123", "456", "asd", "123");
        assertThatThrownBy(() -> InputValidation.validateAllNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Messages.ERROR_INVALID_NUMERIC_INPUT);
    }
}
