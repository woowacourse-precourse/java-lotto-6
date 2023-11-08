package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("count와 hasBonusNumber에 따라 순위를 반환한다.")
    @Test
    void getRank() {
        assertThat(Rank.getRank(6, true)).isEqualTo(FIRST);
        assertThat(Rank.getRank(6, false)).isEqualTo(FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(THIRD);
        assertThat(Rank.getRank(4, true)).isEqualTo(FOURTH);
        assertThat(Rank.getRank(3, true)).isEqualTo(FIFTH);
    }
}