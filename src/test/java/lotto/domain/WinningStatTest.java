package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lotto.system.LottoRankConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatTest {

    @DisplayName("매치 결과가 등수 조건에 맞는지 확인하는 코드")
    @Test
    void isThisRank() {
        assertTrue(WinningStat.create(4).isThis(MatchResult.of(4, false)));
    }

    @DisplayName("수익금을 가져오는 코드")
    @Test
    void getProfit() {
        WinningStat winningStat = WinningStat.create(4);

        winningStat.adder();
        winningStat.adder();

        assertEquals(winningStat.getProfit(), LottoRankConstant.FOURTH_PRIZE.getPrize() * 2);
    }
}
