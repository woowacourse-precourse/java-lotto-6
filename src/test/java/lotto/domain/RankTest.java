package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    @DisplayName("enum값 매핑 테스트")
    void value_of_Match() {
        assertThat(Rank.getMatchRank(3)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("SECOND가 return 되는지 테스트")
    void second_Match() {
        assertThat(Rank.isSecondMatch(5,true)).isEqualTo(Rank.SECOND);
    }


}