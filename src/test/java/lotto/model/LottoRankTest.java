package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoRankTest {

    @Test
    public void 당첨_등수_찾기_테스트() {
        assertThat(LottoRank.FIRST_RANK).isEqualTo(LottoRank.findRank(6, false));
        assertThat(LottoRank.SECOND_RANK).isEqualTo(LottoRank.findRank(5, true));
        assertThat(LottoRank.THIRD_RANK).isEqualTo(LottoRank.findRank(5, false));
        assertThat(LottoRank.FOURTH_RANK).isEqualTo(LottoRank.findRank(4, false));
        assertThat(LottoRank.FIFTH_RANK).isEqualTo(LottoRank.findRank(3, false));
    }

    @Test
    public void 당첨_등수_전체_조회_테스트() {
        List<LottoRank> ranks = LottoRank.getAllRank();
        assertThat(ranks.size()).isEqualTo(5);
        assertThat(ranks.contains(LottoRank.FIRST_RANK)).isTrue();
        assertThat(ranks.contains(LottoRank.SECOND_RANK)).isTrue();
        assertThat(ranks.contains(LottoRank.THIRD_RANK)).isTrue();
        assertThat(ranks.contains(LottoRank.FOURTH_RANK)).isTrue();
        assertThat(ranks.contains(LottoRank.FIFTH_RANK)).isTrue();
    }

}