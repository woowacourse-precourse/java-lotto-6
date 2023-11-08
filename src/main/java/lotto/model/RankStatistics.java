package lotto.model;

import java.util.EnumMap;

public class RankStatistics {

    private EnumMap<Rank, Integer> rankStatistics = new EnumMap<>(Rank.class);

    public EnumMap<Rank, Integer> getRankStatistics() {
        return this.rankStatistics;
    }

    public void add(Rank rank) {
        int rankCount = rankStatistics.getOrDefault(rank, 0);
        rankStatistics.put(rank, rankCount + 1);
    }

    public int getTotalPrize() {
        return this.rankStatistics.keySet().stream()
                .mapToInt(Rank::getPrize)
                .sum();
    }
}