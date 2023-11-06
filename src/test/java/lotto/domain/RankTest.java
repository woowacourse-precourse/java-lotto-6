package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void checkRankWorks() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

}