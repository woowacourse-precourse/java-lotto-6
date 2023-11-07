package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class RankResult {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT = 1;

    private final Map<Rank, Integer> results;

    public RankResult() {
        this.results = new EnumMap<>(Rank.class);
        initialize();
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            results.put(rank, INITIAL_COUNT);
        }
    }

    public void add(Rank rank) {
        results.put(rank, results.get(rank) + INCREMENT);
    }
}
