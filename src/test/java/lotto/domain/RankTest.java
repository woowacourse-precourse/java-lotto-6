package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("랭크검색 조건에 부합한다면 랭크를 반환한다.")
    void findRankSuccess() {
        assertThat(Rank.findRank(5,true)).isNotEmpty().contains(Rank.FIVE_BONUS);
    }

    @Test
    @DisplayName("랭크검색 조건에 부합하지 않는다면 랭크를 반환하지 않는다.")
    void findRankFail() {
        assertThat(Rank.findRank(2,true)).isEmpty();
    }
}
