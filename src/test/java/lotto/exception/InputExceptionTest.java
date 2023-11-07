package lotto.exception;

import static lotto.exception.InputException.NOT_DIGIT_FORM;
import static lotto.exception.InputException.NOT_LOTTO_NUMBERS_FORM;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputExceptionTest {
    @DisplayName("입력이 숫자의 형식이 아니라면 예외 메시지를 반환한다.")
    @Test
    void testNotDigitFormException() {
        //when, then
        assertThatThrownBy(() -> NOT_DIGIT_FORM.throwException())
                .hasMessage(NOT_DIGIT_FORM.getMessage());
    }

    @DisplayName("입력이 올바르지 않은 형식이라면 예외 메시지를 반환한다.")
    @Test
    void testNotLottoNumbersFormException() {
        //when, then
        assertThatThrownBy(() -> NOT_LOTTO_NUMBERS_FORM.throwException())
                .hasMessage(NOT_LOTTO_NUMBERS_FORM.getMessage());
    }
}
