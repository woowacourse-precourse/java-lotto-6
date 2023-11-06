package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("금액이 0인 경우 예외가 발생한다.")
    @Test
    void createZeroMoney() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않은 경우 예외가 발생한다.")
    @Test
    void createIndivisibleMoney() {
        assertThatThrownBy(() -> new Money(1500))
                .isInstanceOf(IllegalArgumentException.class);

    }

}