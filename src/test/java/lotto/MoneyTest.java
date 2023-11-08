package lotto;

import exception.NonPositiveMoneyException;
import exception.WrongMoneyUnitException;
import model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("로또 구입 금액이 0원 이하이면 예외가 발생한다.")
    @Test
    void createMoneyByWrongRange() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(NonPositiveMoneyException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByWrongUnit() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(WrongMoneyUnitException.class);
    }
}
