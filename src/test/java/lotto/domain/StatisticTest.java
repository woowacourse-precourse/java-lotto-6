package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StatisticTest {

    @Test
    @DisplayName("등수 통계 결과 제대로 반환하는지 테스트")
    void 등수_통계_결과_테스트() {
        List<LottoRank> input = new ArrayList<>();
        input.add(LottoRank.FIFTH);
        input.add(LottoRank.LOSE);

        Map<LottoRank, Integer> expectedOutput = new HashMap<>();
        for (LottoRank lottoRank: LottoRank.values()) {
            expectedOutput.put(lottoRank, 0);
        }
        expectedOutput.put(LottoRank.FIFTH,1);
        expectedOutput.put(LottoRank.LOSE, 1);

        Statistic statistic = new Statistic(input);
        Assertions.assertThat(statistic.getLottoRankCount())
                .isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("상금 통계 결과 제대로 반환하는지 테스트")
    void 상금_통계_결과_테스트() {
        List<LottoRank> input = new ArrayList<>();
        input.add(LottoRank.FIFTH);
        input.add(LottoRank.LOSE);

        Statistic statistic = new Statistic(input);
        Assertions.assertThat(statistic.getLottoEarnings())
                .isEqualTo(5000);
    }
}
