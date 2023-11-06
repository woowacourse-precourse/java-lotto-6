package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("로또 구입 금액이 1000원으로 나누어지지 않으면 예외가 발생한다.")
    void divideLottoMoney() {
        assertThatThrownBy(() -> new Money(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}