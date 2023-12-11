package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("금액이 1000원 보다 작으면 예외가 발생한다.")
    @Test
    void isLessThanPrice() {
        assertThatThrownBy(() -> new Money(950))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void isNotDivisibleByPrice() {
        assertThatThrownBy(() -> new Money(1800))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 따라 발행할 로또 매수를 계산한다.")
    @Test
    void countHowManyLotto() {
        Money money = new Money(5000);
        assertThat(money.getHowManyLotto()).isEqualTo(5);
    }
}