package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PlayerLotto;
import lotto.domain.Ranking;
import lotto.domain.RankingCounter;
import lotto.domain.WinningLotto;
import lotto.dto.ComparatorRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCalculatorTest {

    private RankingCounter rankingCounter;

    private LottoCalculator lottoCalculator;

    @BeforeEach
    void setUp() {
        rankingCounter = new RankingCounter();
        lottoCalculator = new LottoCalculator(rankingCounter);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculatePayOff() {
        rankingCounter.increaseRankingCount(3); //5등
        rankingCounter.increaseRankingCount(4); //4등

        Assertions.assertAll(
                () -> Assertions.assertEquals(110.0, lottoCalculator.calculatePayOff(50000))
        );
    }

    @DisplayName("로또 번호들을 비교한다")
    @Test
    void compareLotto() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> playerNumber = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        ComparatorRequest comparatorRequest = new ComparatorRequest(winningLotto,playerNumber);
        lottoCalculator.compareLotto(comparatorRequest);

        Assertions.assertEquals(1,rankingCounter.getCount(Ranking.FIRST));
    }
}
