package lotto.validation;

import static lotto.constant.ValidateMessage.WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.constant.ValidateMessage.WINNER_NUMBER_IS_NOT_INTEGER;
import static lotto.constant.ValidateMessage.WINNER_NUMBER_VALIDATE_ERROR_INPUT;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerNumberValidatorTest {
    private final WinnerNumberValidator winnerNumberValidator;


    WinnerNumberValidatorTest() {
        winnerNumberValidator = new WinnerNumberValidator();
    }

    @DisplayName("당첨 번호는 null or empty 이면 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winnerNumberValidator.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_CANNOT_BE_NULL_OR_EMPTY.message));
    }

    @DisplayName("입력 방법이 올바르지 않으면 예외가 발생한다.")
    @Test
    void validateErrorInputTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winnerNumberValidator.validateErrorInput("1,2,3,4,,5,6"));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_VALIDATE_ERROR_INPUT.message));
    }

    @DisplayName("당첨 번호는 6개를 입력해야 한다.")
    @Test
    void isSizeEqualToSixTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> winnerNumberValidator.isInteger("1,2,3,Not Integer,4,5"));

        //then
        assertTrue(exception.getMessage().contains(WINNER_NUMBER_IS_NOT_INTEGER.message));
    }
}