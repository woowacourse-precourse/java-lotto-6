package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankAndPrizeTest {

    @Test
    public void testDetermineRankByLottoMatched() {

        int lottoMatched = 5;
        boolean bonusMatched = true;

        LottoRankAndPrize result = LottoRankAndPrize.determineRankByLottoMatched(lottoMatched, bonusMatched);

        assertEquals(LottoRankAndPrize.SECOND_RANK, result);
    }

    @Test
    public void testDetermineRankByLottoMatchedNoRank() {
        int lottoMatched = 2;
        boolean bonusMatched = false;

        LottoRankAndPrize result = LottoRankAndPrize.determineRankByLottoMatched(lottoMatched, bonusMatched);

        assertEquals(LottoRankAndPrize.NO_RANK, result);
    }
}
