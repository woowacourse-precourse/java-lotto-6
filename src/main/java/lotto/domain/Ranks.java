package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public Map<Integer, Integer> countRankNum() {
        Map<Integer, Integer> countResult = new HashMap<>();

        for (Rank rank : ranks) {
            Integer key = rank.ordinal();
            countResult.put(key, countResult.getOrDefault(key, 0)+1);
        }

        return countResult;
    }
}
