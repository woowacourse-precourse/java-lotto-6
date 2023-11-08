package model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Rank;
import lotto.model.RankStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankStatisticsTest {

    @DisplayName("순위 통계에 아무것도 추가하지 않으면 통계의 숫자는 0이다.")
    @Test
    void remainStatisticsNumberZeroWithoutAddingRank() {
        RankStatistics rankStatistics = new RankStatistics();
        int firstCountBefore = rankStatistics.getRankStatistics().get(Rank.FIRST);
        rankStatistics.add(Rank.FIRST);
        int firstCountAfter = rankStatistics.getRankStatistics().get(Rank.FIRST);
        assertThat(firstCountBefore).isEqualTo(0);
        assertThat(firstCountBefore).isEqualTo(1);
    }

    @DisplayName("순위 통계에 순위 추가하면 통계의 숫자가 하나 늘어난다.")
    @Test
    void increaseFirstRankStatisticsByAddingFirstRank() {
        RankStatistics rankStatistics = new RankStatistics();
        int firstCountBefore = rankStatistics.getRankStatistics().get(Rank.FIRST);
        rankStatistics.add(Rank.FIRST);
        int firstCountAfter = rankStatistics.getRankStatistics().get(Rank.FIRST);
        assertThat(firstCountBefore).isEqualTo(0);
        assertThat(firstCountBefore).isEqualTo(1);
    }

    @DisplayName("순위 통계에 따른 전체 당첨금을 리턴한다.")
    @Test
    void returnTotalPrizeBasedOnRankStatistics() {
        RankStatistics rankStatistics = new RankStatistics();
        rankStatistics.add(Rank.FIRST);
        rankStatistics.add(Rank.SECOND);
        rankStatistics.add(Rank.FIFTH);
        int totalPrize = rankStatistics.getTotalPrize();
        assertThat(totalPrize).isEqualTo(
                Rank.FIRST.getPrize() +
                        Rank.SECOND.getPrize() +
                        Rank.FIFTH.getPrize()
        );
    }
}