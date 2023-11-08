package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RankStatisticsTest {

    @DisplayName("순위 통계에 아무것도 추가하지 않으면 통계의 숫자는 0이다.")
    @Test
    void remainStatisticsNumberZeroWithoutAddingRank() {
        List<Rank> ranks = new ArrayList<>();
        RankStatistics rankStatistics = new RankStatistics(ranks);
        int firstCount = rankStatistics.getRankStatistics().getOrDefault(Rank.FIRST, 0);
        assertThat(firstCount).isEqualTo(0);
    }

    @DisplayName("순위 통계에 순위 추가하면 통계의 숫자가 하나 늘어난다.")
    @Test
    void increaseFirstRankStatisticsByAddingFirstRank() {
        List<Rank> ranks = new ArrayList<>();
        RankStatistics rankStatistics1 = new RankStatistics(ranks);
        int firstCountBefore = rankStatistics1.getRankStatistics().getOrDefault(Rank.FIRST, 0);
        ranks.add(Rank.FIRST);
        RankStatistics rankStatistics2 = new RankStatistics(ranks);
        int firstCountAfter = rankStatistics2.getRankStatistics().getOrDefault(Rank.FIRST, 0);
        assertThat(firstCountBefore).isEqualTo(0);
        assertThat(firstCountAfter).isEqualTo(1);
    }

    @DisplayName("순위 통계에 따른 수익률을 리턴한다.")
    @Test
    void returnProfitRateBasedOnRankStatistics() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIRST);
        ranks.add(Rank.SECOND);
        ranks.add(Rank.FIFTH);
        RankStatistics rankStatistics = new RankStatistics(ranks);
        double profitRate = rankStatistics.getProfitRate(100000);
        assertThat(profitRate).isEqualTo(
                ((Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + Rank.FIFTH.getPrize()) / (double) 100000)*100
        );
    }
}