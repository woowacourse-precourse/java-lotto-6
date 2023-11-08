package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrizeResultTest {

    @DisplayName("상금 결과 테스트")
    @Test
    void testCalcPrizeResult() {
        PrizeResult prizeResult = new PrizeResult();
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        Lotto winningLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto matchingBonusLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        Lottos lottos = new Lottos(List.of(winningLotto1, matchingBonusLotto));

        prizeResult.calcPrizeResult(winningLotto, lottos);

        assertEquals(1, prizeResult.getPrizeCount(Prize.FIRST));
        assertEquals(1, prizeResult.getPrizeCount(Prize.SECOND));
        assertEquals(0, prizeResult.getPrizeCount(Prize.THIRD));
    }

}