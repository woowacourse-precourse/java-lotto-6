package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5.5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(2)).isEqualTo(Rank.MISS);
    }
}

