package generalexception;

import static generalexception.GeneralExceptionHandler.EMPTY_ERROR_MESSAGE;
import static generalexception.GeneralExceptionHandler.NOT_NUMBER_ERROR_MESSAGE;
import static generalexception.GeneralExceptionHandler.validateEmpty;
import static generalexception.GeneralExceptionHandler.validateNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneralExceptionHandlerTest {
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

