package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusInputValidatorTest {
    private static final InputValidator bonusInputValidator = new BonusInputValidator();

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void bonusNumberIsNotNumeric() {
        //given
        String bonusNumber = "w";

        //when,then
        Assertions.assertThatThrownBy(() -> bonusInputValidator.validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.BONUS_NUMBER_IS_NOT_NUMERIC.getMessage());
    }

    @DisplayName("보너스 번호가 45를 초과할 경우 예외가 발생한다.")
    @Test
    void bonusNumberByOverRange() {
        //given
        String bonusNumber = "50";

        //when,then
        Assertions.assertThatThrownBy(() -> bonusInputValidator.validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.BONUS_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("보너스 번호가 1 미만일 경우 예외가 발생한다.")
    @Test
    void bonusNumberByUnderRange() {
        //given
        String bonusNumber = "0";

        //when,then
        Assertions.assertThatThrownBy(() -> bonusInputValidator.validate(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.BONUS_NUMBER_RANGE_ERROR_MESSAGE.getMessage());
    }
}