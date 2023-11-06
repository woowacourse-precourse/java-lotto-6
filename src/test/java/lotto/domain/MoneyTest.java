package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("로또 구입 금액이 1,000원 이하면 예외 발생.")
    @Test
    void createMoneyByString() {
        assertThatThrownBy(() -> new Money(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아니면 예외 발생.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}