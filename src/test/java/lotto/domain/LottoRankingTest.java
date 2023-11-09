package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoRankingTest {

    @DisplayName("제대로 상수가 가지고 있는 맞은 숫자 개수를 나타내는지 확인")
    @Test
    public void testLottoRankingGetCountOfMatch() {
        assertEquals(6, LottoRanking.FIRST.getCountOfMatch());
        assertEquals(5, LottoRanking.SECOND.getCountOfMatch());
        assertEquals(5, LottoRanking.THIRD.getCountOfMatch());
        assertEquals(4, LottoRanking.FOURTH.getCountOfMatch());
        assertEquals(3, LottoRanking.FIFTH.getCountOfMatch());
        assertEquals(0, LottoRanking.MISS.getCountOfMatch());
    }

    @DisplayName("제대로 상수가 가지고 있는 당첨금액을 나타내는지 확인")
    @Test
    public void testLottoRankingGetWinningAmount() {
        assertEquals(2_000_000_000, LottoRanking.FIRST.getWinningAmount());
        assertEquals(30_000_000, LottoRanking.SECOND.getWinningAmount());
        assertEquals(1_500_000, LottoRanking.THIRD.getWinningAmount());
        assertEquals(50_000, LottoRanking.FOURTH.getWinningAmount());
        assertEquals(5_000, LottoRanking.FIFTH.getWinningAmount());
        assertEquals(0, LottoRanking.MISS.getWinningAmount());
    }

    @DisplayName("올바른 ranking 출력 확인")
    @Test
    public void testLottoRankingValueOf() {
        assertEquals(LottoRanking.FIRST, LottoRanking.valueOf(6, false));
        assertEquals(LottoRanking.SECOND, LottoRanking.valueOf(5, true));
        assertEquals(LottoRanking.THIRD, LottoRanking.valueOf(5, false));
        assertEquals(LottoRanking.FOURTH, LottoRanking.valueOf(4, false));
        assertEquals(LottoRanking.FIFTH, LottoRanking.valueOf(3, false));
        assertEquals(LottoRanking.MISS, LottoRanking.valueOf(2, false));
    }

    @DisplayName("잘못된 값을 넣어 exception이 잘 일어나는지 확인")
    @Test
    public void testLottoRankingValueOfWithInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> LottoRanking.valueOf(7, false));
    }
}