package lotto.validator;

import static lotto.view.message.ErrorMessage.EMPTY_INPUT;
import static lotto.view.message.ErrorMessage.NOT_NUMBER;
import static lotto.view.message.ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 빈_입력_예외_처리() {
        String input = "";
        assertThatThrownBy(() -> InputValidator.validateEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_INPUT.getErrorMessage());
    }

    @Test
    void 숫자가_아닌_문자가_포함된_입력_예외_처리() {
        String input = "15g";
        assertThatThrownBy(() -> InputValidator.validateDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER.getErrorMessage());
    }

    @Test
    void 일과_사십오_사이의_숫자가_아닌_입력_예외_처리() {
        int input = 46;
        assertThatThrownBy(() -> InputValidator.validateNumberOnlyFromOneToFortyFive(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getErrorMessage());
    }
}