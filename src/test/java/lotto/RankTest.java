package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.config.RankConfig;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("로또 등수 확인")
    @Test
    public void testRanking() {
        for (RankConfig rankConfig : RankConfig.values()) {
            int matchedNumbers = rankConfig.getMatchedNumbers();
            boolean matchedBonus = (rankConfig == RankConfig.SECOND);

            RankConfig expectedRank = rankConfig;
            RankConfig actualRank = Rank.ranking(matchedNumbers, matchedBonus);

            assertEquals(expectedRank, actualRank);
        }
    }
}
