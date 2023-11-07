package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.InputValidator;

public class InputValidatorTest {

    @DisplayName("로또 구입 금액이 숫자가 아닌 값이 입력되면 에러가 발생한다.")
    @Test
    void validateNotNumberPurchaseAmountTest() {
        String input = "kkkk";
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchaseAmountInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000 단위가 아니면 에러가 발생한다.")
    @Test
    void validateNotMultipleOf1000PurchaseAmountTest() {
        String input = "1001";
        Assertions.assertThatThrownBy(() -> InputValidator.validatePurchaseAmountInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
