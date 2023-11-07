package lotto.domain;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RankResult {
    private final Map<Rank, Integer> rankToCount;

    public RankResult() {
        rankToCount = initialize();
    }

    private EnumMap<Rank, Integer> initialize() {
        EnumMap<Rank, Integer> rankToCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankToCount.put(rank, 0);
        }
        rankToCount.remove(Rank.NONE);
        return rankToCount;
    }

    public void add(Rank rank) {
        if (rank == Rank.NONE) {
            return;
        }
        rankToCount.put(rank, rankToCount.get(rank) + 1);
    }

    public long getTotalPrize() {
        long totalPrize = 0;
        for (Entry<Rank, Integer> entry : rankToCount.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }

    public Collection<Integer> values() {
        return rankToCount.values();
    }

    public Set<Entry<Rank, Integer>> entrySet() {
        return rankToCount.entrySet();
    }
}
