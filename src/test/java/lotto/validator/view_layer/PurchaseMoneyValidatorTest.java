package lotto.validator.view_layer;

import lotto.constant.NumericConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.constant.NumericConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyValidatorTest {

    PurchaseMoneyValidator purchaseMoneyValidator = new PurchaseMoneyValidator();

    @ParameterizedTest
    @ValueSource(strings = {"0", (long) Integer.MAX_VALUE + 1 + "", (long) Integer.MIN_VALUE - 1 + ""})
    void 입력된_값이_정수범위_자연수여야한다_0도불가능(String input) {
        assertThatThrownBy(() -> purchaseMoneyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {LOTTO_PRICE - 1 + "", LOTTO_PRICE + 1 + "", "1"})
    void 로또_가격에의해_나누어떨어지는지_검증한다(String input) {
        assertThatThrownBy(() -> purchaseMoneyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVISIBLE_BY_LOTTO_PRICE);

        purchaseMoneyValidator.validate(LOTTO_PRICE * 10 + "");
    }
}