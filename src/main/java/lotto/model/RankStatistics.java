package lotto.model;

import java.util.EnumMap;
import java.util.List;

public class RankStatistics {

    private final EnumMap<Rank, Integer> rankStatistics = new EnumMap<>(Rank.class);

    public RankStatistics(List<Rank> ranks) {
        for (Rank rank : ranks) {
            this.add(rank);
        }
    }

    private void add(Rank rank) {
        int rankCount = rankStatistics.getOrDefault(rank, 0);
        rankStatistics.put(rank, rankCount + 1);
    }

    public EnumMap<Rank, Integer> getRankStatistics() {
        return this.rankStatistics;
    }

    public double getProfitRate(int userPayment) {
        return this.getTotalPrize() / (double) userPayment;
    }

    private int getTotalPrize() {
        return this.rankStatistics.keySet().stream()
                .mapToInt(Rank::getPrize)
                .sum();
    }
}