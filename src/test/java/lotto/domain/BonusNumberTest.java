package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @Test
    @DisplayName("숫자가 아닌 입력은 예외가 발생한다.")
    void testBonusNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumber bonusNumber = new BonusNumber(Integer.parseInt("wrongInput"));
        });
        assertDoesNotThrow(() -> {
            BonusNumber bonusNumber = new BonusNumber(Integer.parseInt("45"));
        });
    }

    @Test
    @DisplayName("범위를 벗어나는 입력은 예외가 발생한다.")
    void testIsInRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumber bonusNumber = new BonusNumber(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumber bonusNumber = new BonusNumber(46);
        });
    }
}