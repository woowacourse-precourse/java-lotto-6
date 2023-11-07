package lotto.money;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    public void 유효한_금액으로_객체를_생성한다() {
        int validAmount = 5000;
        Money money = new Money(validAmount);
        assertEquals(validAmount, money.getAmount());
    }

    @Test
    public void 금액이_1000원으로_나누어떨어지지_않으면_예외를_던진다() {
        int invalidAmount = 1500;
        assertThrows(IllegalArgumentException.class, () -> new Money(invalidAmount));
    }
    
}