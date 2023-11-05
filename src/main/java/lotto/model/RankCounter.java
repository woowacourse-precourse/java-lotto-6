package lotto.model;

import java.util.HashMap;

public class RankCounter {

    private HashMap<Rank, Integer> rankCounter = new HashMap<>();

    private RankCounter() {
        for(Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    public static RankCounter create() {
        return new RankCounter();
    }

    public void addRank(Rank rank) {
        int count = rankCounter.getOrDefault(rank, 0) + 1;
        rankCounter.put(rank, count);
    }

    public int getRankCount(Rank rank) {
        return rankCounter.get(rank);
    }
}
