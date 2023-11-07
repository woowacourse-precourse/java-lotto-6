package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void 로또를_추가한다() {
        Lottos lottos = new Lottos();
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 6));

        assertEquals(2, lottos.getLottos().size());
    }

    @Test
    void 로또_결과를_계산한다() {
        Lottos lottos = new Lottos();
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 6));
        lottos.addLotto(List.of(1, 2, 3, 4, 5, 7));
        lottos.addLotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);

        List<Result> results = lottos.calculateResult(winningNumber, bonusNumber);

        assertEquals(List.of(Result.SIX_MATCH, Result.FIVE_MATCH_WITH_BONUS), results);
    }
}