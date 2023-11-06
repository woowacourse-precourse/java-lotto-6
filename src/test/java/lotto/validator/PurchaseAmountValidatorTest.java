package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.validator.ErrorMessage.*;

class PurchaseAmountValidatorTest {
    PurchaseAmountValidator validator = new PurchaseAmountValidator();

    @Test
    void 구매금액_성공() {
        String input = "1000";

        Assertions.assertThatCode(() -> validator.validate(input)).doesNotThrowAnyException();
    }

    @Test
    void 구매금액이_숫자가_아님_검증() {
        String input = "asd";

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input)).
                withMessage(PURCHASE_AMOUNT_IS_NOT_NUMERIC_MESSAGE);
    }

    @Test
    void 구매금액이_올바르지_않음_검증() {
        String input1 = "9001";
        String input2 = "0";

        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input1)).
                withMessage(PURCHASE_AMOUNT_IS_NOT_JUSTIFIED_MESSAGE);
        Assertions.assertThatIllegalArgumentException().
                isThrownBy(() -> validator.validate(input2)).
                withMessage(PURCHASE_AMOUNT_IS_NOT_JUSTIFIED_MESSAGE);

    }

}