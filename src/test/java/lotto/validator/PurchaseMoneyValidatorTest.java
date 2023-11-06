package lotto.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.constant.ErrorMessage.ENTER_PROPER_NATURAL_NUMBER;
import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_BY_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseMoneyValidatorTest {

    @Test
    void 십억이하의_자연수인지_검증() {
        CommonValidatorTest commonValidatorTest = new CommonValidatorTest();

        commonValidatorTest.validateIsNaturalNumber();
    }

    @Test
    void 로또_가격에의해_나누어떨어지는지_검증() {
        assertThatThrownBy(() -> PurchaseMoneyValidator.validate("845645"))
                .hasMessage(NOT_DIVISIBLE_BY_LOTTO_PRICE);

        assertThatThrownBy(() -> PurchaseMoneyValidator.validate("330"))
                .hasMessage(NOT_DIVISIBLE_BY_LOTTO_PRICE);

        PurchaseMoneyValidator.validate("3000");
    }
}