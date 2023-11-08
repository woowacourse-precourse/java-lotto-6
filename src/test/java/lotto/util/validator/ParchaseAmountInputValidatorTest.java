package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParchaseAmountInputValidatorTest {
    private static final InputValidator parchaseAmountInputValidator = new ParchaseAmountInputValidator();

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void parchaseAmountIsNotNumeric() {
        //given
        String parchaseAmount = "w";

        //when,then
        Assertions.assertThatThrownBy(() -> parchaseAmountInputValidator.validate(parchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.PARCHASE_AMOUNT_IS_NOT_NUMERIC.getMessage());
    }

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다")
    @Test
    void parchaseAmountIsNotDivisibleByThousand() {
        //given
        String parchaseAmount = "1234";

        //when,then
        Assertions.assertThatThrownBy(() -> parchaseAmountInputValidator.validate(parchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.PARCHASE_AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
    }

    @DisplayName("구매 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void parchaseAmountIsNotPositive() {
        //given
        String parchaseAmount = "-1000";

        //when,then
        Assertions.assertThatThrownBy(() -> parchaseAmountInputValidator.validate(parchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.PARCHASE_AMOUNT_IS_NOT_POSITIVE_NUMBER.getMessage());
    }
}