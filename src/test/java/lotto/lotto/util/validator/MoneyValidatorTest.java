package lotto.lotto.util.validator;

import lotto.domain.Constant;
import lotto.util.validator.MoneyValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyValidatorTest {
    @DisplayName("최소 금액을 넘지 못하면 예외를 던진다.")
    @Test
    void validateLessThanMinimum() {
        assertThatThrownBy(() -> MoneyValidator.validateMinimumMoney(111))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 금액을 넘어야 한다.")
    @Test
    void validateMinimum() {
        Assertions.assertDoesNotThrow(() ->
                MoneyValidator.validateMinimumMoney(Constant.MONEY_THRESHOLD));
    }

    @DisplayName("1000원으로 나누어 떨어지지 않으면 예외를 던진다.")
    @Test
    void validateNotDivisible() {
        assertThatThrownBy(() -> MoneyValidator.validateMoneyDivisible(11123))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어져야 한다.")
    @Test
    void validateDivisible() {
        Assertions.assertDoesNotThrow(() ->
                MoneyValidator.validateMoneyDivisible(Constant.LOTTO_PRICE * 5));
    }
}
