package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lottoresult.LottoResultStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCheckResultTest {

    @Test
    @DisplayName("updateResult() 메서드의 정상 작동 확인")
    void testUpdateResult() {
        LottoCheckResult result = new LottoCheckResult();
        LottoResultStatus status = LottoResultStatus.FIVE_MATCH;

        result.updateResult(status);
        Map<LottoResultStatus, Integer> resultAfter = result.getResult();

        assertEquals(1, resultAfter.get(status));
    }

    @Test
    @DisplayName("Map이 정상적으로 초기화 되는 지 확인")
    void testInit() {
        LottoCheckResult result = new LottoCheckResult();

        Map<LottoResultStatus, Integer> resultMap = result.getResult();

        assertEquals(0, resultMap.get(LottoResultStatus.FAIL));
        assertEquals(0, resultMap.get(LottoResultStatus.THREE_MATCH));
        assertEquals(0, resultMap.get(LottoResultStatus.FOUR_MATCH));
        assertEquals(0, resultMap.get(LottoResultStatus.FIVE_MATCH));
        assertEquals(0, resultMap.get(LottoResultStatus.FIVE_MATCH_WITH_BONUS));
        assertEquals(0, resultMap.get(LottoResultStatus.ALL_MATCH));
    }
}