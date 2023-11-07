package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

public class RankTest {

    @Test
    void test() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.of(1, false)).isEqualTo(Rank.NOTHING);
        assertThat(Rank.of(0, false)).isEqualTo(Rank.NOTHING);
    }
}