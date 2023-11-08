package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}