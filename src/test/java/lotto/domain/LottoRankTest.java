package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 등수 계산 테스트")
class LottoRankTest {

    @DisplayName("1등 계산 테스트")
    @Test
    void testCalculateRank1() {
        LottoRank rank = LottoRank.of(6, false);
        Assertions.assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @DisplayName("2등 계산 테스트")
    @Test
    void testCalculateRank2() {
        LottoRank rank = LottoRank.of(5, true);
        Assertions.assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("3등 계산 테스트")
    @Test
    void testCalculateRank3() {
        LottoRank rank = LottoRank.of(5, false);
        Assertions.assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("4등 계산 테스트")
    @Test
    void testCalculateRank4() {
        LottoRank rank = LottoRank.of(4, false);
        Assertions.assertThat(rank).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("5등 계산 테스트")
    @Test
    void testCalculateRank5() {
        LottoRank rank = LottoRank.of(3, false);
        Assertions.assertThat(rank).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("등수 없음 계산 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testCalculateRankNone(int matchCount) {
        LottoRank rank = LottoRank.of(matchCount, false);
        Assertions.assertThat(rank).isEqualTo(LottoRank.NONE);
    }
}