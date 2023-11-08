package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("우승 로또와 로또들을 통해 당첨 통계를 계산하다.")
    @Test
    public void getStatistics() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoNumber(7));
        Lottos lottos = new Lottos(Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9))
        ));
        WinningStatistics winningStatistics = new WinningStatistics(winningLotto, lottos);

        Map<Ranking, Integer> statistics = winningStatistics.getStatistics();

        assertEquals(1, statistics.get(Ranking.FIRST));
        assertEquals(1, statistics.get(Ranking.SECOND));
        assertEquals(1, statistics.get(Ranking.THIRD));
    }

    @DisplayName("당첨 통계를 통해 총 당첨 금액을 계산하다.")
    @Test
    public void calculateTotalWinningPrize() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoNumber(7));
        Lottos lottos = new Lottos(Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9))
        ));
        WinningStatistics winningStatistics = new WinningStatistics(winningLotto, lottos);
        Money actualTotalWinningPrize = winningStatistics.calculateTotalWinningPrize();

        Money expectedTotalWinningPrize = new Money(2030050000);

        assertEquals(expectedTotalWinningPrize.getMoney(), actualTotalWinningPrize.getMoney());
    }
}