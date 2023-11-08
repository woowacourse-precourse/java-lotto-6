package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankAndPrizeTest {

    @DisplayName("일치하는 로또 번호 개수로 등수를 결정하는 기능 테스트")
    @Test
    public void testDetermineRankByLottoMatched() {

        int lottoMatched = 5;
        boolean bonusMatched = true;

        LottoRankAndPrize result = LottoRankAndPrize.determineRankByLottoMatched(lottoMatched, bonusMatched);

        assertEquals(LottoRankAndPrize.SECOND_RANK, result);
    }

    @DisplayName("5등 미만에 대해 NO_RANK 결과를 주는 기능 테스트")
    @Test
    public void testDetermineRankByLottoMatchedNoRank() {
        int lottoMatched = 2;
        boolean bonusMatched = false;

        LottoRankAndPrize result = LottoRankAndPrize.determineRankByLottoMatched(lottoMatched, bonusMatched);

        assertEquals(LottoRankAndPrize.NO_RANK, result);
    }
}
