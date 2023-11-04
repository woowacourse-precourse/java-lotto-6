package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoBonusNumberTest {
    @Test
    public void validTest() {
        assertDoesNotThrow(() -> new LottoBonusNumber("1"));
    }

    @Test
    public void typeTest() {
        assertThrows(IllegalArgumentException.class, () -> new LottoBonusNumber("String"));
    }

    @Test
    public void rangeTest() {
        assertThrows(IllegalArgumentException.class, () -> new LottoBonusNumber("50"));
    }
}