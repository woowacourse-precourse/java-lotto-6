package validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validate.Validate.EMPTY_ERROR_MESSAGE;
import static validate.Validate.NOT_NUMBER_ERROR_MESSAGE;
import static validate.Validate.validateEmpty;
import static validate.Validate.validateNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidateTest {
    @DisplayName("입력한 글자가 공백이면 예외처리를 발생한다.")
    @Test
    void validateEmptyTest() {
        String inputStrIsEmpty = "";
        assertThatThrownBy(() -> validateEmpty(inputStrIsEmpty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_ERROR_MESSAGE);
    }

    @DisplayName("입력한 글자가 숫자가 아닐경우 예외처리를 발생한다.")
    @Test
    void validateNumberTest() {
        String inputStr = "1000J";
        assertThatThrownBy(() -> validateNumber(inputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_ERROR_MESSAGE);
    }

}

