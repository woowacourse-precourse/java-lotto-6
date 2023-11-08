package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class RankResult {

    private Map<Rank, Integer> rankResult;

    public RankResult() {
        rankResult = new HashMap<>();
    }

    public void add(Map<Rank, Integer> countResult) {
        countResult.forEach((rank, count) -> {
            rankResult.put(rank, rankResult.getOrDefault(rank, 0) + count);
        });
    }

    public int getCountByRank(Rank rank) {
        return rankResult.getOrDefault(rank, 0);
    }

}
