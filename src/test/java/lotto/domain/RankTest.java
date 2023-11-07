package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("Rank별 맞춘 숫자의 개수 검증")
    @Test
    void testCount() {
        assertEquals(0, Rank.NOTHING.getCount());
        assertEquals(3, Rank.FIFTH.getCount());
        assertEquals(4, Rank.FORTH.getCount());
        assertEquals(5, Rank.THIRD.getCount());
        assertEquals(5, Rank.SECOND.getCount());
        assertEquals(6, Rank.FIRST.getCount());
    }

    @DisplayName("보너스 번호 일치 여부 검증")
    @Test
    void testBonus() {
        assertFalse(Rank.NOTHING.isBonus());
        assertFalse(Rank.FIFTH.isBonus());
        assertFalse(Rank.FORTH.isBonus());
        assertFalse(Rank.THIRD.isBonus());
        assertTrue(Rank.SECOND.isBonus());
        assertFalse(Rank.FIRST.isBonus());
    }

    @DisplayName("등수별 상금 금액 검증")
    @Test
    void testPrizeMoney() {
        assertEquals(0, Rank.NOTHING.getPrize());
        assertEquals(5000, Rank.FIFTH.getPrize());
        assertEquals(50000, Rank.FORTH.getPrize());
        assertEquals(1500000, Rank.THIRD.getPrize());
        assertEquals(30000000, Rank.SECOND.getPrize());
        assertEquals(2000000000, Rank.FIRST.getPrize());
    }


}