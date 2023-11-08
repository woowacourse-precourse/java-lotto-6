package lotto.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRankTest {

    @DisplayName("전체적인 조건에 부합한 등수에 대해서 테스트 한다.")
    @Test
    public void testEvaluateLottoRank() {
        assertEquals(LottoRank.FIFTH, LottoRank.evaluateLottoRank(3, false));
        assertEquals(LottoRank.FOURTH, LottoRank.evaluateLottoRank(4, false));
        assertEquals(LottoRank.THIRD, LottoRank.evaluateLottoRank(5, false));
        assertEquals(LottoRank.SECOND, LottoRank.evaluateLottoRank(5, true));
        assertEquals(LottoRank.FIRST, LottoRank.evaluateLottoRank(6, false));
        assertEquals(LottoRank.NONE, LottoRank.evaluateLottoRank(2, false));
    }

}
