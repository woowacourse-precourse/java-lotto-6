package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoRankTest {

    @Test
    void 로또_등수_계산_테스트() {
        assertThat(LottoRank.calculateRank(5, true))
                .isEqualTo(LottoRank.SECOND_PRIZE);

        assertThat(LottoRank.calculateRank(5, false))
                .isEqualTo(LottoRank.THIRD_PRIZE);

        assertThat(LottoRank.calculateRank(2, false))
                .isEqualTo(LottoRank.NO_PRIZE);

        assertThat(LottoRank.calculateRank(6, false))
                .isEqualTo(LottoRank.FIRST_PRIZE);
    }
}