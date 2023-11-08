package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemMoneyInputTest {

    @DisplayName("빈칸이 주어졌는지 확인")
    @Test
    void checkMoneyBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            SystemMoneyInput.validateNone("");
        });
    }

    @DisplayName("1000으로 안나눠질 시 예외처리 확인하기")
    @Test
    void checkDivision() {
        assertThrows(IllegalArgumentException.class, () -> {
            SystemMoneyInput.validateDivision("6666");
        });
    }

}