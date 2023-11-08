package lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.dto.BonusNumber;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @Test
    void 빈값_생성() {
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(null));
    }

    @Test
    void ZERO_값_생성() {
        assertThrows(IllegalArgumentException.class, ()-> new BonusNumber(0));
    }

    @Test
    void 음수_값_생성() {
        assertThrows(IllegalArgumentException.class, ()-> new BonusNumber(-1));
    }

    @Test
    void 범위보다_큰_값_생성() {
        assertThrows(IllegalArgumentException.class, ()-> new BonusNumber(100));
    }
}