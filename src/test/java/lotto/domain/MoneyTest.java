package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    void 로또_구입_금액이_천원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Money.INSUFFICIENT_AMOUNT_MESSAGE);
    }

    @Test
    void 로또_구입_금액이_천원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Money(5010))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Money.NOT_DIVISIBLE_MESSAGE);
    }

    @Test
    void 올바른_로또_구입_금액() {
        int validAmount = 2000;

        Money money = new Money(validAmount);

        assertEquals(validAmount, money.getAmount());
    }
}