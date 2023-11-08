package lotto;

import lotto.model.LottoPrize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LottoPrizeTest {
    @Test
    void getPrizeTest() {
        assertEquals(2000000000, LottoPrize.FIRST.getPrize());
        assertEquals(30000000, LottoPrize.SECOND.getPrize());
        assertEquals(1500000, LottoPrize.THIRD.getPrize());
        assertEquals(50000, LottoPrize.FOURTH.getPrize());
        assertEquals(5000, LottoPrize.FIFTH.getPrize());
        assertEquals(0, LottoPrize.NONE.getPrize());
    }

    @Test
    void getRankTest() {
        assertEquals(1, LottoPrize.FIRST.getRank());
        assertEquals(2, LottoPrize.SECOND.getRank());
        assertEquals(3, LottoPrize.THIRD.getRank());
        assertEquals(4, LottoPrize.FOURTH.getRank());
        assertEquals(5, LottoPrize.FIFTH.getRank());
        assertEquals(0, LottoPrize.NONE.getRank());
    }

    @Test
    void getMatchCountTest() {
        assertEquals(6, LottoPrize.FIRST.getMatchCount());
        assertEquals(5, LottoPrize.SECOND.getMatchCount());
        assertEquals(5, LottoPrize.THIRD.getMatchCount());
        assertEquals(4, LottoPrize.FOURTH.getMatchCount());
        assertEquals(3, LottoPrize.FIFTH.getMatchCount());
        assertEquals(0, LottoPrize.NONE.getMatchCount());
    }

    @Test
    void getBonusMatchTest() {
        assertFalse(LottoPrize.FIRST.getBonusMatch());
        assertTrue(LottoPrize.SECOND.getBonusMatch());
        assertFalse(LottoPrize.THIRD.getBonusMatch());
        assertFalse(LottoPrize.FOURTH.getBonusMatch());
        assertFalse(LottoPrize.FIFTH.getBonusMatch());
        assertFalse(LottoPrize.NONE.getBonusMatch());
    }

    @Test
    void getPrizeRankByMatchTest() {
        assertEquals(LottoPrize.FIRST, LottoPrize.getPrizeRankByMatch(6, false));
        assertEquals(LottoPrize.SECOND, LottoPrize.getPrizeRankByMatch(5, true));
        assertEquals(LottoPrize.THIRD, LottoPrize.getPrizeRankByMatch(5, false));
        assertEquals(LottoPrize.FOURTH, LottoPrize.getPrizeRankByMatch(4, false));
        assertEquals(LottoPrize.FIFTH, LottoPrize.getPrizeRankByMatch(3, false));
        assertEquals(LottoPrize.NONE, LottoPrize.getPrizeRankByMatch(2, false)); // None일 경우
    }
}
