package lotto.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import lotto.model.CompareResult;
import lotto.view.output.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareResultServiceTest {
    private final OutputView outputView;
    private final StatisticsService statisticsService;

    CompareResultServiceTest() {
        outputView = new OutputView();
        statisticsService = new StatisticsService(outputView);
    }

    @DisplayName("당첨 통계 계산")
    @Test
    void calculateStatisticsTest() {
        //given
        List<CompareResult> result = createStatisitcs();

        int purchasePrice = 8000;

        //when
        String earningPercent = statisticsService.calculateStatistics(result, purchasePrice);

        //then
        assertEquals(earningPercent, "62.5");
    }

    private static List<CompareResult> createStatisitcs() {
        List<CompareResult> result = new ArrayList<>();
        result.add(new CompareResult(0, false));
        result.add(new CompareResult(1, false));
        result.add(new CompareResult(2, false));
        result.add(new CompareResult(0, true));
        result.add(new CompareResult(0, true));
        result.add(new CompareResult(1, true));
        result.add(new CompareResult(2, true));
        result.add(new CompareResult(3, true));
        return result;
    }
}