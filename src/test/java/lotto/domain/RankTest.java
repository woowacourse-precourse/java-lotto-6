package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("getRank 메서드가 2등을 정상적으로 판별하는지")
    @Test
    void getSecondRankTest() {
        Rank rank = Rank.getRank(5,true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("getRank 메서드가 3등을 정상적으로 판별하는지")
    @Test
    void getThirdRankTest() {
        Rank rank = Rank.getRank(5,false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}
