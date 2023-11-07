package lotto.model;

import static lotto.model.LottoStatistics.PrizeInformation.SECOND_PRIZE;
import static lotto.model.LottoStatistics.PrizeInformation.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import lotto.model.LottoStatistics.PrizeInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
    }

    @DisplayName("당첨 결과가 입력되면 통계가 작성")
    @Test
    void testWinningResultsLeadToStatisticsCompilation() {
        ArrayList<PrizeInformation> testResult;
        testResult = new ArrayList<>(List.of(SECOND_PRIZE, THIRD_PRIZE, THIRD_PRIZE));
        Entry<PrizeInformation, Integer> expectedResult1 = new SimpleEntry<>(SECOND_PRIZE, 1);
        Entry<PrizeInformation, Integer> expectedResult2 = new SimpleEntry<>(THIRD_PRIZE, 2);

        lottoStatistics.writeStatistics(testResult);
        Set<Entry<PrizeInformation, Integer>> statisticsResult = lottoStatistics.getStatistics().entrySet();

        assertThat(statisticsResult).contains(expectedResult1, expectedResult2);
    }

    @DisplayName("당첨 통계와 구입금액이 입력되면 수익률 계산")
    @Test
    void testCalculateProfit() {
        ArrayList<PrizeInformation> testResult;
        testResult = new ArrayList<>(List.of(SECOND_PRIZE, THIRD_PRIZE, THIRD_PRIZE));
        int testPurchaseAmount = 100000;
        double expectedProfit = 33000;

        lottoStatistics.writeStatistics(testResult);
        double profit = lottoStatistics.calculateLottoProfit(testPurchaseAmount);

        assertThat(profit).isEqualTo(expectedProfit);
    }

}
