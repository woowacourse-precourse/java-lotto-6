package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.List;
import lotto.model.dto.AnalyzerWinningStatistics;
import lotto.model.dto.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoWinningAnalyzerTest {
    private LottoWinningAnalyzer lottoWinningAnalyzer;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        Lotto mainNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 12;
        WinningNumbers winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);

        lottoWinningAnalyzer = new LottoWinningAnalyzer(lottos, winningNumbers);
    }

    @Test
    void 상금으로_오름차순_정렬된_등수별_당첨_개수를_계산한다() {
        List<WinningResult> winningResults = lottoWinningAnalyzer.calculateSortedWinningResult();

        assertThat(winningResults).hasSize(6)
                .extracting("winningRule", "winningCount")
                .containsExactly(
                        tuple(WinningRule.NO_PRIZE, 0),
                        tuple(WinningRule.FIFTH_PRIZE, 0),
                        tuple(WinningRule.FOURTH_PRIZE, 0),
                        tuple(WinningRule.THIRD_PRIZE, 0),
                        tuple(WinningRule.SECOND_PRIZE, 0),
                        tuple(WinningRule.FIRST_PRIZE, 2)
                );
    }

    @Test
    void 총_수익률을_계산한다() {
        List<WinningResult> winningResults = lottoWinningAnalyzer.calculateSortedWinningResult();

        double yield = lottoWinningAnalyzer.calculateYield(winningResults);

        assertThat(yield).isEqualTo((double) 4_000_000_000L / 2000 * 100);
    }

    @Test
    void 당첨_통계를_생성하면_등수별_당첨_개수와_총_수익률이_계산된다() {
        AnalyzerWinningStatistics analyzerWinningStatistics = lottoWinningAnalyzer.generateWinningStatistics();

        assertThat(analyzerWinningStatistics.winningResults()).hasSize(6)
                .extracting("winningRule", "winningCount")
                .containsExactly(
                        tuple(WinningRule.NO_PRIZE, 0),
                        tuple(WinningRule.FIFTH_PRIZE, 0),
                        tuple(WinningRule.FOURTH_PRIZE, 0),
                        tuple(WinningRule.THIRD_PRIZE, 0),
                        tuple(WinningRule.SECOND_PRIZE, 0),
                        tuple(WinningRule.FIRST_PRIZE, 2)
                );
        assertThat(analyzerWinningStatistics.yield()).isEqualTo((double) 4_000_000_000L / 2000 * 100);
    }
}
