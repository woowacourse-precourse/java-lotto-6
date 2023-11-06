package lotto.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    @DisplayName("등수 반환 코드 테스트")
    public void getRankTest() {
        Rank rank = Rank.getRank(5, true);
        Rank expectedRank = Rank.SECOND;

        assertThat(rank).isEqualTo(expectedRank);
    }
}
