package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValueExceptionTest {
    @DisplayName("숫자인 입력값은 예외가 발생하지 않는다.")
    @Test
    void testValidateNumber_ValidNumber() {

        String validNumber = "42";

        assertThatCode(() -> ValueException.validateNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("숫자가 아닌 입력값은 IllegalStateException 예외가 발생한다.")
    @Test
    void testValidateNumber_InvalidInput() {
        String invalidInput = "abc"; // 숫자가 아닌 문자열


        assertThatThrownBy(() -> ValueException.validateNumber(invalidInput))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 입력값이 숫자가 아닙니다. 다시 입력하세요");
    }
}
