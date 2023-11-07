package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("로또 구입 금액이 0 이면 예외가 발생한다.")
    @Test
    void createMoneyIsZero() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyNotDivisibleBy1000() {
        assertThatThrownBy(() -> new Money(10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
