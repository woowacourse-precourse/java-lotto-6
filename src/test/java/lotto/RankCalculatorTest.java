package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.RankCalculator;
import lotto.util.Winning;
import org.junit.jupiter.api.Test;

public class RankCalculatorTest {
    Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int bonusNumber = 7;


    @Test
    void countFirstRankLotto() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        RankCalculator calculator = new RankCalculator(lottos);

        assertEquals(calculator.countWinningLotto(Winning.FIRST, winningLotto, bonusNumber), 1);
    }

    @Test
    void countSecondRankLotto() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        RankCalculator calculator = new RankCalculator(lottos);

        assertEquals(calculator.countWinningLotto(Winning.SECOND, winningLotto, bonusNumber), 1);
    }

    @Test
    void countThirdRankLotto() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 7, 45)));
        RankCalculator calculator = new RankCalculator(lottos);

        assertEquals(calculator.countWinningLotto(Winning.THIRD, winningLotto, bonusNumber), 1);
    }

    @Test
    void countFourthRankLotto() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 44, 45)));
        RankCalculator calculator = new RankCalculator(lottos);

        assertEquals(calculator.countWinningLotto(Winning.FOURTH, winningLotto, bonusNumber), 1);
    }

    @Test
    void countFifthRankLotto() {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 43, 44, 45)));
        RankCalculator calculator = new RankCalculator(lottos);

        assertEquals(calculator.countWinningLotto(Winning.FIFTH, winningLotto, bonusNumber), 1);
    }
}
