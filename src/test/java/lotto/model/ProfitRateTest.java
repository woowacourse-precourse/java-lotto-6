package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProfitRateTest {
    @Test
    @DisplayName("수익률 계산 테스트")
    void 수익률_계산_테스트() {
        //given
        Map<WinningStrategy, Integer> matchResult = new HashMap<>();
        matchResult.put(WinningStrategy.MATCHES_FOUR, 2);

        //when
        ProfitRate profitRateCalculator = new ProfitRate(matchResult, 2000);
        double profitRate = profitRateCalculator.calculateProfitRate(100000, 2000);

        //then
        assertEquals(5000, profitRate);
    }


}