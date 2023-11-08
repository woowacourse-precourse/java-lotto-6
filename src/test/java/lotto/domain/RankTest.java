package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void Rank_객체_생성() {
        assertThat(Rank.create())
                .isInstanceOf(Rank.class);
    }
}
