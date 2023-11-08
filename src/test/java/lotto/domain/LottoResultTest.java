package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private Map<WinningStatistics, Integer> statistics;
    private LottoResult lottoResult;

    @BeforeEach
    public void setUp() {
        statistics = new LinkedHashMap<>();
        statistics.put(WinningStatistics.FIRST, 0);
        statistics.put(WinningStatistics.SECOND, 0);
        statistics.put(WinningStatistics.THIRD, 0);
        statistics.put(WinningStatistics.FOURTH, 0);
        statistics.put(WinningStatistics.FIFTH, 1);
        statistics.put(WinningStatistics.MISS, 7);

        lottoResult = new LottoResult(statistics);
    }

    @Test
    @DisplayName("getSortedStatistics 메서드는 출력 형태에 맞게 MISS 통계를 지운다.")
    void getSortedStatistics_Method_Remove_MISS() {
        Map<WinningStatistics, Integer> sortedStatistics = lottoResult.getSortedStatistics();

        assertEquals(sortedStatistics.size(), 5);
    }

    @Test
    @DisplayName("1등부터 5등으로 맵에 저장되어있는 데이터를 출력 형태에 맞게 5등부터 1등으로 정렬한다")
    public void getSortedStatistics_Method_Sorting_Statistics() {
        Map<WinningStatistics, Integer> sortedStatistics = lottoResult.getSortedStatistics();

        WinningStatistics[] expectedOrder = {
                WinningStatistics.FIFTH,
                WinningStatistics.FOURTH,
                WinningStatistics.THIRD,
                WinningStatistics.SECOND,
                WinningStatistics.FIRST
        };

        int index = 0;
        for (WinningStatistics statistic : sortedStatistics.keySet()) {
            assertEquals(statistic, expectedOrder[index]);
            index++;
        }
    }

    @Test
    @DisplayName("calculateProfitPercent 메서드가 올바른 수익률을 계산하는지 테스트")
    void calculateProfitPercent_ShouldReturnCorrectValue() {
        double profitPercent = lottoResult.calculateProfitPercent();

        assertEquals(profitPercent, 62.5, 0.01);
    }
}
