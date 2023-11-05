package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class RankCounter {
    private final Map<Rank, Integer> counter;

    public RankCounter() {
        counter = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            counter.put(rank, 0);
        }
    }

    public void increment(Rank rank) {
        counter.put(rank, counter.get(rank) + 1);
    }

    public Map<Rank, Integer> getCounter() {
        return counter;
    }
}
