package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("count와 hasBonusNumber에 따라 순위를 반환한다.")
    @Test
    void getRank() {
        assertThat(Rank.getRank(6, true)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3, true)).isEqualTo(Rank.FIFTH);
    }
}