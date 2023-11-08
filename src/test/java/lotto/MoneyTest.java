package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.money.MoneyPositiveException;
import lotto.exception.money.NonPositiveTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    static final int VALID_VALUE = 2000;

    @DisplayName("화폐의 금액이 음수이면 예외가 발생한다.")
    @Test
    void createMoneyByNegativeValue() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(MoneyPositiveException.class);
    }

    @DisplayName("0으로 배수 여부를 판별하면 예외가 발생한다.")
    @Test
    void isMultipleOfByZeroValue() {
        Money money = new Money(VALID_VALUE);
        assertThatThrownBy(() -> money.isMultipleOf(0))
                .isInstanceOf(NonPositiveTargetException.class);
    }

    @DisplayName("음수로 배수 여부를 판별하면 예외가 발생한다.")
    @Test
    void isMultipleOfByNegativeValue() {
        Money money = new Money(VALID_VALUE);
        assertThatThrownBy(() -> money.isMultipleOf(-1))
                .isInstanceOf(NonPositiveTargetException.class);
    }


    @DisplayName("0으로 나누기를 하면 예외가 발생한다.")
    @Test
    void divideByNegativeValue() {
        Money money = new Money(VALID_VALUE);
        assertThatThrownBy(() -> money.divide(0))
                .isInstanceOf(NonPositiveTargetException.class);
    }

    @DisplayName("음수로 나누기를 하면 예외가 발생한다.")
    @Test
    void divideByZeroValue() {
        Money money = new Money(VALID_VALUE);
        assertThatThrownBy(() -> money.divide(-1))
                .isInstanceOf(NonPositiveTargetException.class);
    }
}
