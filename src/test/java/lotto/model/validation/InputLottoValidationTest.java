package lotto.model.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.view.ExceptionMessage;
import lotto.utils.Constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputLottoValidationTest {

    @DisplayName("입력값이 정수가 아닐 경우 예외 발생")
    @Test
    void whenInputIsNotInteger_thenThrowException() {
        String invalidInput = "abc";
        assertThatThrownBy(() -> InputLottoValidation.validateInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
    }

    @DisplayName("입력값이 자연수가 경우 예외 발생")
    @Test
    void whenInputIsNotNatural_thenThrowException() {
        String nonNaturalInput = "0";
        assertThatThrownBy(() -> InputLottoValidation.validateInput(nonNaturalInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NATURAL_NUMBER_ERROR.getMessage());
    }

    @DisplayName("티켓 가격으로 나눌 수 없는 입력값에 대해 예외 발생")
    @Test
    void whenInputIsNotDivisibleByTicketPrice_thenThrowException() {
        int nonDivisibleInput = Constants.LOTTO_TICKET_PRICE - 1;
        assertThatThrownBy(() -> InputLottoValidation.validateInput(String.valueOf(nonDivisibleInput)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("올바른 입력값에 대해서는 올바른 로또 수를 계산한다")
    @Test
    void whenInputIsValid_thenCalculateCorrectLottoCount() {
        int validInput = Constants.LOTTO_TICKET_PRICE * 5;
        InputLottoValidation validation = new InputLottoValidation(validInput);
        int lottoCount = validation.calculateLottoCount();
        assertEquals(5, lottoCount);
    }

    @DisplayName("올바른 입력값에 대해 예외가 발생하지 않는다")
    @Test
    void whenInputIsValid_thenNoExceptionThrown() {
        int validInput = Constants.LOTTO_TICKET_PRICE * 5;
        assertThatThrownBy(() -> InputLottoValidation.validateInput(String.valueOf(validInput)))
                .doesNotThrowAnyException();
    }
}
