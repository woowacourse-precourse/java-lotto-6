package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 등수 테스트")
class LottoRankTest {
    @DisplayName("1등 테스트")
    @Test
    void testCalculateRank1() {
        Rank rank = Rank.calculate(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등 테스트")
    @Test
    void testCalculateRank2() {
        Rank rank = Rank.calculate(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("3등 테스트")
    @Test
    void testCalculateRank3() {
        Rank rank = Rank.calculate(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4등 테스트")
    @Test
    void testCalculateRank4() {
        Rank rank = Rank.calculate(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("5등 테스트")
    @Test
    void testCalculateRank5() {
        Rank rank = Rank.calculate(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("꽝 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testCalculateRankLose(int matchCount) {
        Rank rank = Rank.calculate(matchCount, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}