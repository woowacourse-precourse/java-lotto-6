package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("로또 구입 금액이 1000원으로 나누어지지 않으면 예외가 발생한다.")
    void divideLottoMoney() {
        assertThatThrownBy(() -> new Money(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액에 음수를 넣으면 예외가 발생한다.")
    void negativeMoney() {
        assertThatThrownBy(() -> new Money(-1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액이 0 이상이고 1000으로 나뉘어진다면 예외가 발생하지 않는다.")
    void successMoney() {
        // when & then
        Assertions.assertDoesNotThrow(()-> new Money(1000));
    }
}