package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @Test
    void getRank() {
        assertEquals(1, Rank.FIRST.getRank());
        assertEquals(2, Rank.SECOND.getRank());
        assertEquals(3, Rank.THIRD.getRank());
        assertEquals(4, Rank.FOURTH.getRank());
        assertEquals(5, Rank.FIFTH.getRank());
    }

    @Test
    void getReward() {
        assertEquals(2_000_000_000, Rank.FIRST.getReward());
        assertEquals(30_000_000, Rank.SECOND.getReward());
        assertEquals(1_500_000, Rank.THIRD.getReward());
        assertEquals(50_000, Rank.FOURTH.getReward());
        assertEquals(5_000, Rank.FIFTH.getReward());
    }

    @Test
    void getMessage() {
        assertEquals("6개 일치 (2,000,000,000원)", Rank.FIRST.getMessage());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", Rank.SECOND.getMessage());
        assertEquals("5개 일치 (1,500,000원)", Rank.THIRD.getMessage());
        assertEquals("4개 일치 (50,000원)", Rank.FOURTH.getMessage());
        assertEquals("3개 일치 (5,000원)", Rank.FIFTH.getMessage());
    }
}
