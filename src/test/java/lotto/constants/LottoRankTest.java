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

    @DisplayName("등수당 금액이 맞는지 테스트 한다.")
    @Test
    public void testGetPrizeMoney() {
        assertEquals(5000, LottoRank.FIFTH.getPrizeMoney());
        assertEquals(50000, LottoRank.FOURTH.getPrizeMoney());
        assertEquals(1500000, LottoRank.THIRD.getPrizeMoney());
        assertEquals(30000000, LottoRank.SECOND.getPrizeMoney());
        assertEquals(2000000000, LottoRank.FIRST.getPrizeMoney());
        assertEquals(0, LottoRank.NONE.getPrizeMoney());
    }

    @DisplayName("해당하는 등수에 맞는 설명이 출력되는지 테스트한다.")
    @Test
    public void testGetDescription() {
        assertEquals("3개 일치 (5,000원)", LottoRank.FIFTH.getDescription());
        assertEquals("4개 일치 (50,000원)", LottoRank.FOURTH.getDescription());
        assertEquals("5개 일치 (1,500,000원)", LottoRank.THIRD.getDescription());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", LottoRank.SECOND.getDescription());
        assertEquals("6개 일치 (2,000,000,000원)", LottoRank.FIRST.getDescription());
        assertEquals("", LottoRank.NONE.getDescription());
    }
}
