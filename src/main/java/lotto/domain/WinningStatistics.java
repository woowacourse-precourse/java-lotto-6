package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);


    private WinningStatistics(List<Rank> winningRanks) {
        winningRanks.forEach(rank -> rankCount.put(rank, rankCount.getOrDefault(rank, 0)+1));
    }

    public static WinningStatistics from(List<Rank> winningRanks) {
        return new WinningStatistics(winningRanks);
    }

    public int showCountOf(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }


    public long showRevenue() {

    }

}
