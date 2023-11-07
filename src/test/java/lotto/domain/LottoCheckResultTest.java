package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lottoresult.LottoResultStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class LottoCheckResultTest {

    @ParameterizedTest
    @EnumSource(value = LottoResultStatus.class, names = {"FIVE_MATCH"})
    @DisplayName("updateResult() 메서드의 정상 작동 확인")
    void testUpdateResult(LottoResultStatus status) {
        LottoCheckResult result = new LottoCheckResult();

        result.updateResult(status);

        Map<LottoResultStatus, Integer> resultAfterUpdate = result.getResult();

        assertEquals(1, resultAfterUpdate.get(status));
    }

    @ParameterizedTest
    @EnumSource(value = LottoResultStatus.class)
    @DisplayName("Map이 정상적으로 초기화 되는 지 확인")
    void testInit(LottoResultStatus status) {
        LottoCheckResult result = new LottoCheckResult();

        Map<LottoResultStatus, Integer> resultMap = result.getResult();

        assertEquals(0, resultMap.get(status));
    }
}