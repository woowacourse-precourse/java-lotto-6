package generalexceptionhandler;

import static generalexceptionhandler.GeneralExceptionHandler.isNotEmpty;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeneralExceptionHandlerTest {
    @DisplayName("입력한 글자가 공백이면 예외처리를 발생한다.")
    @Test
    void isNotEmptyTest() {
        String inputStrIsEmpty = "";
        assertThatThrownBy(() -> isNotEmpty(inputStrIsEmpty))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

