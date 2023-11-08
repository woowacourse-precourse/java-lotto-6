package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;



class ProfitRateTest {
    @DisplayName("수익률 계산 테스트")
    @Test
    void profitRateCalculateTest() {
        //given
        Map<WinningCriteria, Integer> matchResult = Map.of(
                WinningCriteria.MATCHES_THREE, 1,
                WinningCriteria.MATCHES_FOUR, 2
        );

        //when
        ProfitRate profitRateCalculator = new ProfitRate(matchResult, 130000);

        //then
        assertEquals(80.8, profitRateCalculator.getProfitRate(), 0.1);
    }


}