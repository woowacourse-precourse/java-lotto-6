package lotto.domain;

import java.util.EnumMap;

public class WinningResult {
    private final EnumMap<Rank, Integer> results;

    public WinningResult() {
        results = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void addResult(Rank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }
}
