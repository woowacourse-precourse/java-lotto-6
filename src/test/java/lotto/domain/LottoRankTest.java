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

}

