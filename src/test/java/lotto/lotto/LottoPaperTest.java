package lotto.lotto;

import java.util.Collections;
import java.util.List;
import lotto.bonus.BonusNumber;
import lotto.ranking.Ranking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPaperTest {

    @DisplayName("로또 종이에 당첨 번호와 보너스 번호로 랭킹 결과를 생성")
    @Test
    void createRankingResults() {
        LottoPaper lottoPaper = new LottoPaper(getTestLottos());
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.of("7", winningLotto);

        List<Ranking> rankings = lottoPaper.calculateRankings(winningLotto, bonusNumber);

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
