package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않는 값으로 생성 불가능")
    void createMoneyNot1000Multiples() {
        assertThatThrownBy(() -> new Money(5001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Money 생성 테스트")
    void createMoneyTest() {
        Money money = new Money(5000);
        assertEquals(money.getMoney(), 5000);
    }

}