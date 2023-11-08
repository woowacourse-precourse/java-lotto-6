package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class WinningResultTest {

    @DisplayName("당첨 결과를 생성할 때 각 등수의 빈도수 생성된다.")
    @Test
    void createRankingCount() {
        // given
        List<Ranking> rankings = List.of(Ranking.FAIL, Ranking.FAIL, Ranking.FIFTH, Ranking.FIFTH);
        int purchasePrice = 4000;

        // when
        WinningResult winningResult = new WinningResult(rankings, purchasePrice);
        Map<Ranking, Integer> rankingCount = winningResult.getRankingCount();

        // then
        Assertions.assertThat(rankingCount.get(Ranking.FAIL)).isEqualTo(2);
        Assertions.assertThat(rankingCount.get(Ranking.FIFTH)).isEqualTo(2);
    }

    @DisplayName("당첨 결과를 생성할 때 수익률이 생성된다.")
    @Test
    void createReturnRate() {
        // given
        List<Ranking> rankings = List.of(Ranking.FAIL, Ranking.FAIL, Ranking.FIFTH, Ranking.FIFTH);
        int purchasePrice = 4000;

        // when
        WinningResult winningResult = new WinningResult(rankings, purchasePrice);

        // then
        double returnRate = (double) (Ranking.FIFTH.getReward() * 2) / purchasePrice * 100;
        Assertions.assertThat(winningResult.getReturnRate()).isEqualTo(returnRate);
    }
}
