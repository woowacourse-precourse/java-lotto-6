package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("로또 등수를 올바르게 반환하는지 확인")
    void testLottoRankValueOf() {
        assertThat(LottoRank.valueOf(0, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("일치하는 숫자가 5개지만 보너스 번호가 일치하지 않는 경우 3등을 반환하는지 확인")
    void testThirdRankCondition() {
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("매치된 숫자가 없는 경우 NONE을 반환하는지 확인")
    void testNoneRankCondition() {
        assertThat(LottoRank.valueOf(1, false)).isEqualTo(LottoRank.NONE);
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
    }

}

