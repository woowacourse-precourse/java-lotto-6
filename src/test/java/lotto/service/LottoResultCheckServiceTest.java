package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.model.Result;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.Test;

class LottoResultCheckServiceTest {

    LottoResultCheckService lottoResultCheckService = new LottoResultCheckService();

    @Test
    void 당첨번호와_로또번호의_동일한_숫자를_제외하고_제거한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 4, 7, 9, 20));
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        Bonus bonus = new Bonus(winningNumber.getNumbers(), "7");
        Result result = lottoResultCheckService.computeResultAfterRemovingNonCommonNumbers(lotto, winningNumber, bonus);

        Ranking ranking = result.findMatchingRanking();

        assertEquals(ranking.getMatchedCount(), 3);
        assertEquals(ranking, Ranking.THREE);
    }



}