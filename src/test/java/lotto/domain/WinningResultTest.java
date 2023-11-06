package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.Map;

class WinningResultTest {

    @DisplayName("WinningResult 생성시 rankingCount가 초기화된다.")
    @ParameterizedTest
    void createRankingCount() {
        List<Ranking> rankings = List.of(Ranking.FAIL, Ranking.FAIL, Ranking.FIFTH, Ranking.FIFTH);
        int purchasePrice = 4000;

        WinningResult winningResult = new WinningResult(rankings, purchasePrice);

        Map<Ranking, Integer> rankingCount = winningResult.getRankingCount();
        Assertions.assertThat(rankingCount.get(Ranking.FAIL)).isEqualTo(2);
        Assertions.assertThat(rankingCount.get(Ranking.FIFTH)).isEqualTo(2);
    }

    @DisplayName("WinningResult 생성시 returnRate가 초기화된다.")
    @Test
    void createReturnRate() {
        List<Ranking> rankings = List.of(Ranking.FAIL, Ranking.FAIL, Ranking.FIFTH, Ranking.FIFTH);
        int purchasePrice = 4000;

        WinningResult winningResult = new WinningResult(rankings, purchasePrice);

        Assertions.assertThat(winningResult.getReturnRate()).isEqualTo(250);
    }
}
