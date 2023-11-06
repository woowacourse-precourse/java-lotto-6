package lotto.domain.statistic;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.ranking.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticTest {

    @DisplayName("생성 시 모든 등수에 대한 카운트가 0으로 초기화 된다.")
    @Test
    void allRankCountsInitializedToZero() {
        // when
        Statistic statistic = Statistic.init();

        // then
        statistic.keySet().forEach(
            key -> assertThat(statistic.get(key)).isEqualTo(0)
        );
    }

    @DisplayName("해당하는 등수의 카운트를 1만큼 증가시킬 수 있다.")
    @Test
    void increaseCountOfRank() {
        // given
        Statistic statistic = Statistic.init();
        LottoRanking ranking = LottoRanking.FIRST;

        // when
        statistic.addCount(ranking);

        // then
        assertThat(statistic.get(ranking)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void calculateEarningRate() {
        // given
        Statistic statistic = Statistic.init();
        statistic.addCount(LottoRanking.FIFTH);
        statistic.addCount(LottoRanking.UNRANKED);
        statistic.addCount(LottoRanking.UNRANKED);
        statistic.addCount(LottoRanking.UNRANKED);
        statistic.addCount(LottoRanking.UNRANKED);
        statistic.addCount(LottoRanking.UNRANKED);
        statistic.addCount(LottoRanking.UNRANKED);
        statistic.addCount(LottoRanking.UNRANKED);

        // when
        double earningRate = statistic.calculateEarningRate();

        // then
        assertThat(earningRate).isEqualTo(62.5);
    }
}