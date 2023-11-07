package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalyzerWinningStatisticsTest {
    private AnalyzerWinningStatistics analyzerWinningStatistics;

    @BeforeEach
    void setUp() {
        WinningResult firstPrize = new WinningResult(WinningRule.FIRST_PRIZE, 0);
        WinningResult secondPrize = new WinningResult(WinningRule.SECOND_PRIZE, 0);
        WinningResult thirdPrize = new WinningResult(WinningRule.THIRD_PRIZE, 0);
        WinningResult fourthPrize = new WinningResult(WinningRule.FOURTH_PRIZE, 0);
        WinningResult fifthPrize = new WinningResult(WinningRule.FIFTH_PRIZE, 1);
        List<WinningResult> winningResults = List.of(firstPrize, secondPrize, thirdPrize, fourthPrize, fifthPrize);
        analyzerWinningStatistics = AnalyzerWinningStatistics.ofSorted(winningResults, 62.5499);
    }

    @Test
    void 모든_등수에_대한_당첨_결과를_하위등수부터_정렬해_포맷팅한다() {
        String expectedWinningResults = """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                """;

        String formattedWinningResults = analyzerWinningStatistics.formatWinningResults();

        assertThat(formattedWinningResults).isEqualTo(expectedWinningResults);
    }

    @Test
    void 수익률을_소수점_둘째_자리에서_반올림해_포맷팅한다() {
        String expectedWinningYield = "총 수익률은 62.5%입니다.";

        String formattedWinningYield = analyzerWinningStatistics.formatWinningYield();

        assertThat(formattedWinningYield).isEqualTo(expectedWinningYield);
    }
}
