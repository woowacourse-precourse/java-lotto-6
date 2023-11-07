package lotto.service;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatsServiceTest {

    @DisplayName("수익률 계산 확인")
    @Test
    void calculateReturnRate() {
        LottoStatsService lottoStatsService = new LottoStatsService();
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        lottoResult.put(LottoRank.LOSING, 9);
        lottoResult.put(LottoRank.FIFTH, 1);
        lottoResult.put(LottoRank.FOURTH, 0);
        lottoResult.put(LottoRank.THIRD, 0);
        lottoResult.put(LottoRank.SECOND, 0);
        lottoResult.put(LottoRank.FIRST, 0);
        double returnRate = lottoStatsService.calculateReturnRate(lottoResult);
        Assertions.assertThat(returnRate).isEqualTo(50.0);

    }
}