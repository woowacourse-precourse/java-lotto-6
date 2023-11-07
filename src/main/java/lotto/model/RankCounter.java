package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCounter {
    private static final List<Rank> ranks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    private final Map<Rank, Integer> rankCounter = new HashMap<>();

    public RankCounter(List<Rank> ranks) {
        for (Rank rank : ranks) {
            rankCounter.put(rank, rankCounter.getOrDefault(rank, 0) + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : ranks) {
            sb.append(rank)
                    .append(" - ")
                    .append(rankCounter.get(rank)).append("개\n");
        }
        return sb.toString();
    }
}
