package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountValidatorTest {
    @DisplayName("구입 금액이 양의 정수가 아닐 경우 예외 발생")
    @Test
    void validateIsPositiveInteger_NotPositiveInteger_ExceptionThrown() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateIsPositiveInteger("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
    @Test
    void validateIsPositiveInteger_NotNumeric_ExceptionThrown() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateIsPositiveInteger("adbc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 빈 문자열인 경우 예외 발생")
    @Test
    void validateIsPositiveInteger_Empty_ExceptionThrown() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateIsPositiveInteger(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원으로 안나눠지면 예외 발생")
    @Test
    void validateIsDivisibleByThousand_NotDivisible_ExceptionThrown() {
        assertThatThrownBy(() -> PurchaseAmountValidator.validateIsDivisibleByThousand(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
