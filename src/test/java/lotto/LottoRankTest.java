package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 등수 테스트")
class LottoRankTest {
    @DisplayName("1등 테스트")
    @Test
    void testCalculateRank1() {
        LottoRank rank = LottoRank.calculate(6, false);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등 테스트")
    @Test
    void testCalculateRank2() {
        LottoRank rank = LottoRank.calculate(5, true);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 테스트")
    @Test
    void testCalculateRank3() {
        LottoRank rank = LottoRank.calculate(5, false);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4등 테스트")
    @Test
    void testCalculateRank4() {
        LottoRank rank = LottoRank.calculate(4, false);
        assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("5등 테스트")
    @Test
    void testCalculateRank5() {
        LottoRank rank = LottoRank.calculate(3, false);
        assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("꽝 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testCalculateRankLose(int matchCount) {
        LottoRank rank = LottoRank.calculate(matchCount, false);
        assertThat(rank).isEqualTo(LottoRank.LOSE);
    }
}