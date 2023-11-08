package lotto.rank.domain;

import java.util.List;


public class RankStatistics {

    private final RankRecorder rankRecorder;
    private final RevenueCalculator revenueCalculator;

    public RankStatistics() {
        this.rankRecorder = new RankRecorder();
        this.revenueCalculator = new RevenueCalculator();
    }

    public void recordLottoRanks(List<Rank> ranks) {
        rankRecorder.recordRanks(ranks);
    }

    public double calculateLottoRevenueRate(int purchaseAmount) {
        return revenueCalculator.calculateRevenueRate(rankRecorder.getRankCount(), purchaseAmount);
    }

    public RankCount getRankCount() {
        return rankRecorder.getRankCount();
    }
}


