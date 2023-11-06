package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void calculateRank_테스트() {
        Rank rank = Rank.calculateRank(3, false);
        Assertions.assertEquals(Rank.MATCH_3, rank);

        rank = Rank.calculateRank(3, true);
        Assertions.assertNull(rank);

        rank = Rank.calculateRank(5, true);
        Assertions.assertEquals(Rank.MATCH_5_BONUS, rank);

        rank = Rank.calculateRank(5, false);
        Assertions.assertEquals(Rank.MATCH_5, rank);

        rank = Rank.calculateRank(6, false);
        Assertions.assertEquals(Rank.MATCH_6, rank);
    }

    @Test
    void getPrize_테스트() {
        Rank rank = Rank.MATCH_3;
        Assertions.assertEquals(5000, rank.getPrize());

        rank = Rank.MATCH_5;
        Assertions.assertEquals(1_500_000, rank.getPrize());
    }

    @Test
    void getCountOfWin_테스트() {
        Rank rank = Rank.MATCH_3;
        Assertions.assertEquals(1, rank.getCountOfWin());

        rank = Rank.MATCH_4;
        Assertions.assertEquals(0, rank.getCountOfWin());
    }

    @Test
    void isMatchBonus_테스트() {
        Rank rank = Rank.MATCH_5_BONUS;
        Assertions.assertTrue(rank.isMatchBonus());

        rank = Rank.MATCH_5;
        Assertions.assertFalse(rank.isMatchBonus());
    }
}
