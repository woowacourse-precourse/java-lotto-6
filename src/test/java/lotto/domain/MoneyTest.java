package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @DisplayName("구매 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void createMoneyByNot1000Unit() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}