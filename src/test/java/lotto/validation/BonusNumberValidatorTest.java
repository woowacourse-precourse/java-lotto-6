package lotto.validation;

import static lotto.constant.ValidateMessage.BONUS_NUMBER_CANNOT_BE_NULL_OR_EMPTY;
import static lotto.constant.ValidateMessage.BONUS_NUMBER_IS_NOT_INTEGER;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    private final BonusNumberValidator bonusNumberValidator;

    BonusNumberValidatorTest() {
        bonusNumberValidator = new BonusNumberValidator();
    }

    @DisplayName("보너스 번호는 null or empty 이면 예외가 발생한다.")
    @Test
    void isNullOrEmptyTest() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bonusNumberValidator.isNullOrEmpty(null));

        //then
        assertTrue(exception.getMessage().contains(BONUS_NUMBER_CANNOT_BE_NULL_OR_EMPTY.message));
    }

    @DisplayName("보너스 번호는 정수가 아닌 문자가 입력되면 예외가 발생한다.")
    @Test
    void isNotInteger() {
        //given
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bonusNumberValidator.isInteger("1,2,3,4,5,6"));

        //then
        assertTrue(exception.getMessage().contains(BONUS_NUMBER_IS_NOT_INTEGER.message));
    }
}