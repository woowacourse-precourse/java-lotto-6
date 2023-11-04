package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void find() {
        Rank rank1 = Rank.find(5, false);
        Rank rank2 = Rank.find(5, true);
        Rank rank3 = Rank.find(6, false);
        Rank rank4 = Rank.find(6, true);
        Rank rank5 = Rank.find(0, true);
        assertThat(rank1).isEqualTo(Rank.THREE);
        assertThat(rank2).isEqualTo(Rank.TWO);
        assertThat(rank3).isEqualTo(Rank.ONE);
        assertThat(rank4).isEqualTo(Rank.ONE);
        assertThat(rank5).isEqualTo(Rank.NONE);
    }
}
