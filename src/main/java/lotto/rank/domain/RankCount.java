package lotto.rank.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class RankCount {
    private final Map<Rank, Integer> rankCount;

    public RankCount() {
        rankCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void recordRank(Rank rank) {
        rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }

    public Map<Rank, Integer> getUnmodifiableRankCount() {
        return Collections.unmodifiableMap(rankCount);
    }

}
