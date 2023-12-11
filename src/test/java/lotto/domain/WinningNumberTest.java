package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 5));
        });
    }

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 46));
        });
    }
}