package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParchaseAmountInputValidatorTest {
    private static final InputValidator parchaseAmountInputValidator = new ParchaseAmountInputValidator();

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void parchaseAmountIsNotNumeric() {
        //given
        String parchaseAmount = "w";

        //when,then
        Assertions.assertThatThrownBy(() -> parchaseAmountInputValidator.validate(parchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.PARCHASE_AMOUNT_IS_NOT_NUMERIC.getMessage());
    }

    
}