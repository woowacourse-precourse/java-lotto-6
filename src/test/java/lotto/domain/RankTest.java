package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    @DisplayName("enum값 매핑 테스트")
    void valueOfMatchCount() {
        assertThat(Rank.getMatchRank(5)).isEqualTo(Rank.SECOND);
    }


}