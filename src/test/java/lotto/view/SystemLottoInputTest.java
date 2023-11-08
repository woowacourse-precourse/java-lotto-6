package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemLottoInputTest {

    @DisplayName("빈칸이 주어졌을 때 예외처리")
    @Test
    void checkLottoBlank() {
        assertThrows(IllegalArgumentException.class, () -> {
            SystemLottoInput.validatePickLotto("");
        });
    }

    @DisplayName("잘못된 값이 주어졌을 떄 예외처리 체크")
    @Test
    void checkCorrectInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            SystemLottoInput.validateCorrectInput(",,");
        });
    }

    @DisplayName("숫자가 아닌 문자가 주어졌을 때 예외처리")
    @Test
    void checkLottoWrongInputString() {
        assertThrows(IllegalArgumentException.class, () -> {
            SystemLottoInput.validateString("a");
        });
    }

}