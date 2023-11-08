package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("당첨 순위에 대한 카운트 확인")
    @Test
    void getRankCount() {
        Rank.addRankCount(Rank.THIRD);
        assertThat(Rank.getRankCount(Rank.THIRD)).isEqualTo(1);

        Rank.minusThirdRankCount();
        assertThat(Rank.getRankCount(Rank.THIRD)).isEqualTo(0);
    }

    @DisplayName("총 수익 계산 확인")
    @Test
    void getTotalEarning() {
        Rank.addRankCount(Rank.FIFTH);
        Rank.addRankCount(Rank.SECOND);
        Rank.addRankCount(Rank.FIRST);

        assertThat(Rank.getTotalEarning())
                .isEqualTo(2030005000);
    }

}
