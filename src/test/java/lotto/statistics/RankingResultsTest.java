package lotto.statistics;

import java.util.Collections;
import java.util.List;
import lotto.bonus.BonusNumber;
import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.ranking.Ranking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankingResultsTest {

    @DisplayName("로또 결과를 종합하여 결과 리스트를 생성한다.")
    @Test
    void createRankingResults() {
        List<Lotto> lottos = getTestLottos();
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7");

        RankingResults rankingResults = RankingResults.of(lottos, winningLotto, bonusNumber);
        List<Ranking> rankings = rankingResults.getRankings();

        Assertions.assertAll(
                () -> Assertions.assertEquals(Collections.frequency(rankings, Ranking.FIRST), 1),
                () -> Assertions.assertEquals(Collections.frequency(rankings, Ranking.SECOND), 1),
                () -> Assertions.assertEquals(Collections.frequency(rankings, Ranking.FOURTH), 2),
                () -> Assertions.assertEquals(Collections.frequency(rankings, Ranking.NOTHING), 1)
        );
    }

    private List<Lotto> getTestLottos() {
        return List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(2, 3, 4, 5, 7, 8)),
                new Lotto(List.of(10, 12, 34, 41, 42, 43)),
                new Lotto(List.of(1, 2, 5, 6, 42, 43))

        );
    }
}
