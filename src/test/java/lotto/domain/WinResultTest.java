package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class WinResultTest {
    private static final int WINNING = 1;
    private final WinResult winResult = new WinResult();

    @DisplayName("등수에 해당하는 값 증가")
    @ParameterizedTest
    @ValueSource(ints = {5, 7, 6})
    void increaseWinResultValue(int rankValue) {
        winResult.increaseWinResultValue(rankValue);

        assertEquals(winResult.getWinResultValue(rankValue), WINNING);

    }

    @DisplayName("당첨 번호와 일치하는 값 개수가 2초과인지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    void isOverTwo(int rankValue) {
        assertEquals(winResult.isOverTwo(rankValue), true);
    }

    @DisplayName("당첨 번호와 일치하는 값 개수가 2이하인지 확인")
    @Test
    void isNotOverTwo() {
        int rankValue = 2;
        assertEquals(winResult.isOverTwo(rankValue), false);
    }

    @DisplayName("당첨 번호와 일치하는 값 개수가 5인지 확인")
    @Test
    void isFiveSame() {
        int rankValue = 5;
        assertEquals(winResult.isFiveSame(rankValue), true);
    }

    @DisplayName("당첨 번호와 일치하는 값 개수가 5가 아닌지 확인")
    @Test
    void isNotFiveSame() {
        int rankValue = 2;
        assertEquals(winResult.isFiveSame(rankValue), false);
    }

}
