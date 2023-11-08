package lotto.constant;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("적중 숫자와 보너스 여부로부터 순위를 찾을 수 있음")
    void findRank() {
        assertThat(Rank.findRank(6, false))
            .isEqualTo(Rank.FIRST);

        assertThat(Rank.findRank(5, true))
            .isEqualTo(Rank.SECOND);

        assertThat(Rank.findRank(5, false))
            .isEqualTo(Rank.THIRD);

        assertThat(Rank.findRank(4, true))
            .isEqualTo(Rank.FOURTH);

        assertThat(Rank.findRank(4, false))
            .isEqualTo(Rank.FOURTH);

        assertThat(Rank.findRank(3, true))
            .isEqualTo(Rank.FIFTH);

        assertThat(Rank.findRank(3, false))
            .isEqualTo(Rank.FIFTH);

        assertThat(Rank.findRank(2, true))
            .isNull();
    }
}