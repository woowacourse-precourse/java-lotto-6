package lotto.util.validator;

import lotto.util.validator.constant.ErrorMessageConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountInputValidatorTest {
    private static final InputValidator purchaseAmountInputValidator = new PurchaseAmountInputValidator();

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void purchaseAmountIsNotNumeric() {
        //given
        String purchaseAmount = "w";

        //when,then
        Assertions.assertThatThrownBy(() -> purchaseAmountInputValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_NUMERIC.getMessage());
    }

    @DisplayName("구매 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다")
    @Test
    void purchaseAmountIsNotDivisibleByThousand() {
        //given
        String purchaseAmount = "1234";

        //when,then
        Assertions.assertThatThrownBy(() -> purchaseAmountInputValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND.getMessage());
    }

    @DisplayName("구매 금액이 음수일 경우 예외가 발생한다.")
    @Test
    void purchaseAmountIsNotPositive() {
        //given
        String purchaseAmount = "-1000";

        //when,then
        Assertions.assertThatThrownBy(() -> purchaseAmountInputValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class).hasMessage(ErrorMessageConstant.PURCHASE_AMOUNT_IS_NOT_POSITIVE_NUMBER.getMessage());
    }
}