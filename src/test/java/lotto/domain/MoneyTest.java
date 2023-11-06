package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void 금액은_천원_이상이어야_한다() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Money.INSUFFICIENT_AMOUNT_MESSAGE);
    }

    @Test
    void 금액은_천원_단위여야_한다() {
        assertThatThrownBy(() -> new Money(5010))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Money.NOT_DIVISIBLE_MESSAGE);
    }

    @Test
    void 올바른_금액() {
        int validAmount = 2000;

        Money money = new Money(validAmount);

        assertEquals(validAmount, money.getAmount());
    }
}