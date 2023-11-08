package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("calculateRank와 Rank의 결과가 다르면 예외 발생")
    @Test
    void calculateRank_제대로_동작하는지_테스트() {
        Assertions.assertEquals(Rank.MATCH_3, Rank.calculateRank(3, false));
        Assertions.assertNull(Rank.calculateRank(3, true));
        Assertions.assertEquals(Rank.MATCH_5_BONUS, Rank.calculateRank(5, true));
        Assertions.assertEquals(Rank.MATCH_5, Rank.calculateRank(5, false));
        Assertions.assertEquals(Rank.MATCH_6, Rank.calculateRank(6, false));
    }

    @DisplayName("해당 rank와 상금이 일치하면 예외 발생하지않음")
    @Test
    void rank와_getPrizeMoney_일치_여부_테스트() {
        Rank rank = Rank.MATCH_3;
        Assertions.assertEquals(5000, rank.getPrizeMoney());

        rank = Rank.MATCH_4;
        Assertions.assertEquals(50_000, rank.getPrizeMoney());

        rank = Rank.MATCH_5;
        Assertions.assertEquals(1_500_000, rank.getPrizeMoney());

        rank = Rank.MATCH_5_BONUS;
        Assertions.assertEquals(30_000_000, rank.getPrizeMoney());

        rank = Rank.MATCH_6;
        Assertions.assertEquals(2_000_000_000, rank.getPrizeMoney());
    }

    @DisplayName("해당 rank와 초기 승리횟수가 일치하면 예외 발생하지않음")
    @Test
    void rank와_getCountOfWin_일치_여부_테스트() {
        Rank rank = Rank.MATCH_3;
        Assertions.assertEquals(0, rank.getCountOfWin());

        rank = Rank.MATCH_4;
        Assertions.assertEquals(0, rank.getCountOfWin());

        rank = Rank.MATCH_5;
        Assertions.assertEquals(0, rank.getCountOfWin());

        rank = Rank.MATCH_5_BONUS;
        Assertions.assertEquals(0, rank.getCountOfWin());

        rank = Rank.MATCH_6;
        Assertions.assertEquals(0, rank.getCountOfWin());
    }

    @DisplayName("해당 rank와 isMatchBonus 값이 일치하면 예외 발생하지않음")
    @Test
    void rank와_isMatchBonus_일치_여부_테스트() {
        Rank rank = Rank.MATCH_3;
        Assertions.assertFalse(rank.isMatchBonus());

        rank = Rank.MATCH_4;
        Assertions.assertFalse(rank.isMatchBonus());

        rank = Rank.MATCH_5;
        Assertions.assertFalse(rank.isMatchBonus());

        rank = Rank.MATCH_5_BONUS;
        Assertions.assertTrue(rank.isMatchBonus());

        rank = Rank.MATCH_6;
        Assertions.assertFalse(rank.isMatchBonus());
    }
}
