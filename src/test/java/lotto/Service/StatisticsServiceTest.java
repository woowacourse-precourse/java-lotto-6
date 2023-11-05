package lotto.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Statistics;
import lotto.view.output.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsServiceTest {
    private final OutputView outputView;
    private final StatisticsService statisticsService;

    StatisticsServiceTest() {
        outputView = new OutputView();
        statisticsService = new StatisticsService(outputView);
    }

    @DisplayName("당첨 통계 계산")
    @Test
    void calculateStatisticsTest() {
        //given
        List<Statistics> result = createStatisitcs();

        int purchasePrice = 8000;

        //when
        String earningPercent = statisticsService.calculateStatistics(result, purchasePrice);

        //then
        assertEquals(earningPercent, "62.5");
    }

    private static List<Statistics> createStatisitcs() {
        List<Statistics> result = new ArrayList<>();
        result.add(new Statistics(0, false));
        result.add(new Statistics(1, false));
        result.add(new Statistics(2, false));
        result.add(new Statistics(0, true));
        result.add(new Statistics(0, true));
        result.add(new Statistics(1, true));
        result.add(new Statistics(2, true));
        result.add(new Statistics(3, true));
        return result;
    }
}