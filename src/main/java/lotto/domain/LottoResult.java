package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> ranksCount;

    public LottoResult() {
        ranksCount = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            ranksCount.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        ranksCount.put(rank, ranksCount.get(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return ranksCount.getOrDefault(rank, 0);
    }

    public long calculateTotalPrizeMoney() {
        return ranksCount.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(int purchaseAmount) {
        long totalPrizeMoney = calculateTotalPrizeMoney();
        return (double) totalPrizeMoney / purchaseAmount * 100;
    }
}
