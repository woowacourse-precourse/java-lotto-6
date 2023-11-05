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

}
