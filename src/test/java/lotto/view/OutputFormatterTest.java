package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningRule;
import lotto.model.dto.AnalyzerWinningStatistics;
import lotto.model.dto.BuyerLottoHistory;
import lotto.model.dto.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputFormatterTest {
    private BuyerLottoHistory buyerLottoHistory;
    private AnalyzerWinningStatistics analyzerWinningStatistics;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        buyerLottoHistory = new BuyerLottoHistory(2, List.of(lotto1, lotto2));

        WinningResult firstPrize = new WinningResult(WinningRule.FIRST_PRIZE, 0);
        WinningResult secondPrize = new WinningResult(WinningRule.SECOND_PRIZE, 0);
        WinningResult thirdPrize = new WinningResult(WinningRule.THIRD_PRIZE, 0);
        WinningResult fourthPrize = new WinningResult(WinningRule.FOURTH_PRIZE, 0);
        WinningResult fifthPrize = new WinningResult(WinningRule.FIFTH_PRIZE, 1);
        List<WinningResult> winningResults = List.of(firstPrize, secondPrize, thirdPrize, fourthPrize, fifthPrize);
        analyzerWinningStatistics = AnalyzerWinningStatistics.ofSorted(winningResults, 62.5499);
    }

    @Test
    void 구매된_로또_개수를_포맷팅한다() {
        assertThat(OutputFormatter.formatBuyerLottoCount(buyerLottoHistory))
                .isEqualTo("2개를 구매했습니다.");
    }

    @Test
    void 구매된_로또_번호들을_포맷팅한다() {
        assertThat(OutputFormatter.formatBuyerLottos(buyerLottoHistory))
                .isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]");
    }

    @Test
    void 등수에_대한_당첨_개수를_포맷팅한다() {
        WinningResult winningResult = new WinningResult(WinningRule.THIRD_PRIZE, 2);

        assertThat(OutputFormatter.formatWinningResult(winningResult))
                .isEqualTo("5개 일치 (1,500,000원) - 2개\n");
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

        String formattedWinningResults = OutputFormatter.formatWinningResults(analyzerWinningStatistics);

        assertThat(formattedWinningResults).isEqualTo(expectedWinningResults);
    }

    @Test
    void 수익률을_소수점_둘째_자리에서_반올림해_포맷팅한다() {
        String expectedWinningYield = "총 수익률은 62.5%입니다.";

        String formattedWinningYield = OutputFormatter.formatWinningYield(analyzerWinningStatistics);

        assertThat(formattedWinningYield).isEqualTo(expectedWinningYield);
    }
}
