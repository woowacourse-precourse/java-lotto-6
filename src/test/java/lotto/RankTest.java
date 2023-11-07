package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("calculateRank 계산 테스트")
    @Test
    void calculateRank와_Rank의_결과가_다르면_예외가_발생한다() {
        Assertions.assertEquals(Rank.MATCH_3, Rank.calculateRank(3, false));
        Assertions.assertNull(Rank.calculateRank(3, true));
        Assertions.assertEquals(Rank.MATCH_5_BONUS, Rank.calculateRank(5, true));
        Assertions.assertEquals(Rank.MATCH_5, Rank.calculateRank(5, false));
        Assertions.assertEquals(Rank.MATCH_6, Rank.calculateRank(6, false));
    }

    @DisplayName("rank와 getPrizeMoney 일치 여부 테스트")
    @Test
    void 해당_rank와_상금이_일치하지_않으면_예외가_발생한다() {
        Rank rank = Rank.MATCH_3;
        Assertions.assertEquals(5000, rank.getPrizeMoney());

        rank = Rank.MATCH_5;
        Assertions.assertEquals(1_500_000, rank.getPrizeMoney());
    }

    @DisplayName("rank와 getCountOfWin 일치 여부 테스트")
    @Test
    void 해당_rank와_초기_승리횟수가_일치하지_않으면_예외가_발생한다() {
        Rank rank = Rank.MATCH_3;
        Assertions.assertEquals(0, rank.getCountOfWin());

        rank = Rank.MATCH_5_BONUS;
        Assertions.assertEquals(0, rank.getCountOfWin());

        rank = Rank.MATCH_5;
        Assertions.assertEquals(0, rank.getCountOfWin());
    }

    @DisplayName("rank와 isMatchBonus 일치 여부 테스트")
    @Test
    void 해당_rank와_isMatchBonus_값이_일치하지_않으면_예외가_발생한다() {
        Rank rank = Rank.MATCH_5_BONUS;
        Assertions.assertTrue(rank.isMatchBonus());

        rank = Rank.MATCH_5;
        Assertions.assertFalse(rank.isMatchBonus());
    }
}
