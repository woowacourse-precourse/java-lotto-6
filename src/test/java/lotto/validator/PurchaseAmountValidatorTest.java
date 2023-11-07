package lotto.validator;

import static lotto.view.message.ErrorMessage.EMPTY_INPUT;
import static lotto.view.message.ErrorMessage.NOT_NUMBER;
import static lotto.view.message.ErrorMessage.NOT_PRICE_UNITS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {
    @Test
    void 구입_금액_빈_입력_예외_처리() {
        String input = "";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EMPTY_INPUT.getErrorMessage());
    }

    @Test
    void 구입_금액_숫자가_아닌_문자가_포함된_입력_예외_처리() {
        String input = "15000g";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER.getErrorMessage());
    }

    @Test
    void 구입_금액_1000_단위가_아닌_입력_예외_처리() {
        String input = "1234";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_PRICE_UNITS.getErrorMessage());
    }
}