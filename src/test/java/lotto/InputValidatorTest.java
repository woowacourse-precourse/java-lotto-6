package lotto;

import io.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.ValidationErrorMessages.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @DisplayName("로또 구입 금액이 정수가 아니면 예외를 발생한다.")
    @Test
    void validateLottoPurchaseAmountByNotInteger() {
        String input = "1000.0";

        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_INTEGER.getMessage());
    }

    @DisplayName("로또 구입 금액이 최소 금액 미만이면 예외를 발생한다.")
    @Test
    void validateLottoPurchaseAmountByUnderAmount() {
        String input = "500";

        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BELOW_MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외를 발생한다.")
    @Test
    void validateLottoPurchaseAmountByNotMultiple() {
        String input = "2001";

        assertThatThrownBy(() -> validator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MULTIPLE_OF_PRICE.getMessage());
    }
}
