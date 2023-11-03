package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckResultTest {

    @Test
    @DisplayName("updateResult() 메서드의 정상 작동 확인")
    void testUpdateResult() {
        LottoCheckResult result = new LottoCheckResult();
        WinningStatus status = WinningStatus.FIVE_MATCH;

        result.updateResult(status);
        Map<WinningStatus, Integer> resultAfter = result.getResult();

        assertEquals(1, resultAfter.get(status));
    }

    @Test
    @DisplayName("Map이 정상적으로 초기화 되는 지 확인")
    void testInit() {
        LottoCheckResult result = new LottoCheckResult();

        Map<WinningStatus, Integer> resultMap = result.getResult();

        assertEquals(0, resultMap.get(WinningStatus.FAIL));
        assertEquals(0, resultMap.get(WinningStatus.THREE_MATCH));
        assertEquals(0, resultMap.get(WinningStatus.FOUR_MATCH));
        assertEquals(0, resultMap.get(WinningStatus.FIVE_MATCH));
        assertEquals(0, resultMap.get(WinningStatus.FIVE_MATCH_WITH_BONUS));
        assertEquals(0, resultMap.get(WinningStatus.ALL_MATCH));
    }
}