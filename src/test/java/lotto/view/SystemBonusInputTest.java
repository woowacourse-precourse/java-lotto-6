package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemBonusInputTest {

    @DisplayName("빈칸이 주어졌을 때 예외처리하는 지 확인하기")
    @Test
    void checkBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            SystemBonusInput.validateNone("");
        });
    }

    @DisplayName("숫자가 아닌 문자가 주어졌을 때 예외처리")
    @Test
    void checkWrongInputString() {
        assertThrows(IllegalArgumentException.class, () -> {
            SystemBonusInput.validateBonusNum("a");
        });
    }

}