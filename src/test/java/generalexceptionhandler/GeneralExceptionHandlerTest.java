package generalexceptionhandler;

import static generalexceptionhandler.GeneralExceptionHandler.EMPTY_ERROR_MESSAGE;
import static generalexceptionhandler.GeneralExceptionHandler.NOT_NUMBER_ERROR_MESSAGE;
import static generalexceptionhandler.GeneralExceptionHandler.checkEmpty;
import static generalexceptionhandler.GeneralExceptionHandler.checkNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneralExceptionHandlerTest {
    @DisplayName("입력한 글자가 공백이면 예외처리를 발생한다.")
    @Test
    void checkEmptyTest() {
        String inputStrIsEmpty = "";
        assertThatThrownBy(() -> checkEmpty(inputStrIsEmpty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EMPTY_ERROR_MESSAGE);
    }

    @DisplayName("입력한 글자가 숫자가 아닐경우 예외처리를 발생한다.")
    @Test
    void checkNumberTest() {
        String inputStr = "";
        assertThatThrownBy(() -> checkNumber(inputStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER_ERROR_MESSAGE);
    }

}

