package lotto.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void 숫자가_아닌_입력은_오류를_던져야함() {
        assertThrows(IllegalArgumentException.class, () -> new Money("asd"));
    }

    @Test
    void 입력이_1000의_배수가_아니면_오류를_던져야함() {
        assertThrows(IllegalArgumentException.class, () -> new Money("500"));
        assertThrows(IllegalArgumentException.class, () -> new Money("1500"));
    }

    @Test
    void 입력이_양수가_아니면_오류를_던져야함() {
        assertThrows(IllegalArgumentException.class, () -> new Money("-100"));
        assertThrows(IllegalArgumentException.class, () -> new Money("00"));
        assertThrows(IllegalArgumentException.class, () -> new Money("0"));
    }

    @Test
    void 입력이_정상인_경우() {
        Money money = new Money("2000");
        assertEquals(2000, money.amount);
    }
}