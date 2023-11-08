package lotto.domain;

import java.util.Arrays;
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

    public int calculateTotalPrizeMoney() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getPrizeMoney() * results.get(rank))
                .sum();
    }

    public double calculateYield(int purchaseAmount) {
        return 100. * (double) calculateTotalPrizeMoney() / purchaseAmount;
    }
}
