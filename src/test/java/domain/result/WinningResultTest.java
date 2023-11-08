package domain.result;

import domain.result.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningResultTest {

    @Test
    @DisplayName("1등 상금 테스트")
    public void testGetWinningResultFirst() {
        WinningResult result = WinningResult.getWinningResult(6, false);
        assertEquals(WinningResult.FIRST, result);
    }

    @Test
    @DisplayName("2등 상금 테스트")
    public void testGetWinningResultSecond() {
        WinningResult result = WinningResult.getWinningResult(5, true);
        assertEquals(WinningResult.SECOND, result);
    }

    @Test
    @DisplayName("3등 상금 테스트")
    public void testGetWinningResultThird() {
        WinningResult result = WinningResult.getWinningResult(5, false);
        assertEquals(WinningResult.THIRD, result);
    }

    @Test
    @DisplayName("4등 상금 테스트")
    public void testGetWinningResultFourth() {
        WinningResult result = WinningResult.getWinningResult(4, false);
        assertEquals(WinningResult.FOURTH, result);
    }

    @Test
    @DisplayName("5등 상금 테스트")
    public void testGetWinningResultFifth() {
        WinningResult result = WinningResult.getWinningResult(3, false);
        assertEquals(WinningResult.FIFTH, result);
    }


    @ParameterizedTest
    @DisplayName("꽝 테스트")
    @ValueSource(ints = {0, 1, 2})
    public void testGetWinningResultLose(int matchCount) {
        WinningResult result = WinningResult.getWinningResult(matchCount, false);
        assertEquals(WinningResult.LOSE, result);
    }
}

