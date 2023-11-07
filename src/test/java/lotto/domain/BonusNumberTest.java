package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @Test
    @DisplayName("숫자가 아닌 입력은 예외가 발생한다.")
    void testBonusNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            BonusNumber bonusNumber = new BonusNumber("wrongInput");
        });
        assertDoesNotThrow(() -> {
            BonusNumber bonusNumber = new BonusNumber("45");
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

    @Test
    @DisplayName("보너스 번호의 생성 테스트")
    void testGetNumber() {
        int number1 = 23;
        BonusNumber bonusNumber1 = new BonusNumber(number1);
        assertEquals(number1, bonusNumber1.getNumber());

        String number2 = "23";
        BonusNumber bonusNumber2 = new BonusNumber(number2);
        assertEquals(Integer.parseInt(number2), bonusNumber2.getNumber());
    }
}