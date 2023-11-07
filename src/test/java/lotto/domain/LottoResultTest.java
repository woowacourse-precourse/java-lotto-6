package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @DisplayName("당첨 결과 계산")
    @Test
    void testCalculateResult() {

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        Rank result = LottoResult.calculateResult(lotto, winningNumber);

        assertEquals(Rank.FIRST, result);
    }

    @DisplayName("여러 로또에 대한 등수 목록 가져오기")
    @Test
    void testGetRanks() {

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12));
        List<Lotto> lottos = List.of(lotto1, lotto2);
        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoResult lottoResult = new LottoResult();

        List<Rank> ranks = lottoResult.getRanks(lottos, winningNumber);

        assertTrue(ranks.contains(Rank.FIRST));
        assertTrue(ranks.contains(Rank.NOTHING));
        assertEquals(2, ranks.size());
    }

    @DisplayName("유효한 등수 값 가져오기")
    @Test
    void testGetRankValues() {

        List<Rank> rankValues = LottoResult.getRankValues();

        assertTrue(rankValues.contains(Rank.FIRST));
        assertFalse(rankValues.contains(Rank.NOTHING));
    }

    @DisplayName("특정 등수의 개수 세기")
    @Test
    void testRankCount() {

        List<Rank> results = List.of(Rank.FIRST, Rank.THIRD, Rank.FIRST, Rank.SECOND, Rank.FIRST);

        long firstCount = LottoResult.rankCount(Rank.FIRST, results);

        assertEquals(3, firstCount);
    }

    @DisplayName("총 수익률 계산")
    @Test
    void testTotalEarningRate() {

        List<Rank> results = List.of(Rank.FIRST, Rank.THIRD, Rank.SECOND);

        double earnings = LottoResult.totalEarningRate(results);

        assertEquals(Rank.FIRST.getPrize() + Rank.THIRD.getPrize() + Rank.SECOND.getPrize(), earnings);
    }


}