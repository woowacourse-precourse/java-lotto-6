package lotto.rank.domain;

import java.util.List;

public class RankRecorder {

    private final RankCount rankCount;

    public RankRecorder() {
        this.rankCount = new RankCount();
    }

    public void recordRanks(List<Rank> ranks) {
        for (Rank rank : ranks) {
            rankCount.recordRank(rank);
        }
    }

    public RankCount getRankCount() {
        return rankCount;
    }
}
