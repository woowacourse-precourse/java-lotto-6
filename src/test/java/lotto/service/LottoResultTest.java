package lotto.model;

import lotto.domain.Lotto;
import lotto.service.LottoResult;
import lotto.service.LottoType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    @Test
    void 로또_6개_일치() {
        List<Lotto> playerLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Lotto> winningLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 7;

        lottoResult = new LottoResult(playerLotto, winningLotto, bonus);
        lottoResult.compareLotto();

        assertTrue(lottoResult.getMatchLottoCountMap().containsKey(LottoType.MATCH_SIX));
    }

    @Test
    void 로또_5게_일치() {
        List<Lotto> playerLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        List<Lotto> winningLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 7;

        lottoResult = new LottoResult(playerLotto, winningLotto, bonus);
        lottoResult.compareLotto();

        assertTrue(lottoResult.getMatchLottoCountMap().containsKey(LottoType.MATCH_FIVE));
    }

    @Test
    void 로또_4게_일치() {
        List<Lotto> playerLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 9, 8)));
        List<Lotto> winningLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 7;

        lottoResult = new LottoResult(playerLotto, winningLotto, bonus);
        lottoResult.compareLotto();

        assertTrue(lottoResult.getMatchLottoCountMap().containsKey(LottoType.MATCH_FOUR));
    }

    @Test
    void 로또_3게_일치() {
        List<Lotto> playerLotto = List.of(new Lotto(List.of(1, 2, 3, 8, 11, 34)));
        List<Lotto> winningLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 7;

        lottoResult = new LottoResult(playerLotto, winningLotto, bonus);
        lottoResult.compareLotto();

        assertTrue(lottoResult.getMatchLottoCountMap().containsKey(LottoType.MATCH_THREE));
    }

    @Test
    void 로또_5게_일치_보너스번호() {
        List<Lotto> playerLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        List<Lotto> winningLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 7;

        lottoResult = new LottoResult(playerLotto, winningLotto, bonus);
        lottoResult.compareLotto();

        assertTrue(lottoResult.getMatchLottoCountMap().containsKey(LottoType.MATCH_FIVE_BONUS));
    }
    @Test
    void rateOfReturn() {
        List<Lotto> playerLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 7, 9)));
        List<Lotto> winningLotto = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 7;
        int price = 1000;

        lottoResult = new LottoResult(playerLotto, winningLotto, bonus);
        lottoResult.compareLotto();

        assertEquals(5000.0, lottoResult.rateOfReturn(price));
    }
}
