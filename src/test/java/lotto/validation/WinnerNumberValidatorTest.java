package lotto.validation;

import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_ERROR_INPUT;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_IS_MORE_THAN_ONE;
import static lotto.exception.ErrorInputException.ErrorMessage.WINNER_NUMBER_IS_NOT_INTEGER;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinnerNumberValidatorTest {
    private final WinnerNumberValidator winnerNumberValidator;

    WinnerNumberValidatorTest() {
        winnerNumberValidator = new WinnerNumberValidator();
    }

    @DisplayName("당첨 번호는 빈 값이거나 null이면 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winnerNumberValidator.isBlank(null));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY.getMessage()));
    }

    @DisplayName("당첨 번호로 정수가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void isIntegerTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winnerNumberValidator.isInteger("Not Integer"));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_IS_NOT_INTEGER.getMessage()));
    }

    @DisplayName("당첨 번호는 1보다 큰 자연수가 아니면 예외가 발생한다.")
    @Test
    void bonusNumber_Greater_Than_One() {
        //given
        List<Integer> input = List.of(-1, 0, 1, 2, 3, 4);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winnerNumberValidator.moreThanOne(input));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_IS_MORE_THAN_ONE.getMessage()));
    }

    @DisplayName("당첨 번호 입력시 ,,를 입력하거나 가장 앞과 뒤는 숫자로 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,,5,6", "1,2,3,4,5,6,", ",1,2,3,4,5,6"})
    void double_Comma_Test(String input) {
        //given

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winnerNumberValidator.checkCommaError(input));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_ERROR_INPUT.getMessage()));
    }
}