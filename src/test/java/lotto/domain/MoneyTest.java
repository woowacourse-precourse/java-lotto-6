package lotto.domain;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("구입 금액이 1000으로 나눌 수 없으면 예외가 발생한다.")
    @Test
    void createMoneyByNotDivision1000() {
        assertThatThrownBy(() -> new Money(10001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이라면 예외가 발생한다.")
    @Test
    void createMoneyByZeroNumber(){
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}