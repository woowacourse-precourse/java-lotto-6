package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRankingsTest {


    @DisplayName("총 당첨금을 계산한다.")
    @Test
    void calculateTotalPrizeSuccessTest() {

        // given
        List<LottoRanking> rankings = List.of(LottoRanking.FIRST, LottoRanking.SECOND, LottoRanking.SECOND);
        LottoRankings lottoRankings = new LottoRankings(rankings);

        // when
        long totalPrize = lottoRankings.calculateTotalPrize();

        // then
        assertThat(totalPrize).isEqualTo(2_060_000_000);
    }
}