package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("각 등수에 해당하는 매치 카운트와 상금이 올바른지 확인")
    void checkLottoRankValues() {
        assertEquals(6, LottoRank.FIRST.getMatchCount());
        assertEquals(2_000_000_000, LottoRank.FIRST.getPrizeMoney());

        assertEquals(5, LottoRank.SECOND.getMatchCount());
        assertEquals(30_000_000, LottoRank.SECOND.getPrizeMoney());

        assertEquals(5, LottoRank.THIRD.getMatchCount());
        assertEquals(1_500_000, LottoRank.THIRD.getPrizeMoney());

        assertEquals(4, LottoRank.FOURTH.getMatchCount());
        assertEquals(50_000, LottoRank.FOURTH.getPrizeMoney());

        assertEquals(3, LottoRank.FIFTH.getMatchCount());
        assertEquals(5_000, LottoRank.FIFTH.getPrizeMoney());

        assertEquals(0, LottoRank.NONE.getMatchCount());
        assertEquals(0, LottoRank.NONE.getPrizeMoney());
    }
}
