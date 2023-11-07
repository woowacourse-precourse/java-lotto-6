package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
    }

    public void record(LottoRank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getCount(LottoRank rank) {
        return result.get(rank);
    }

    public long getTotalEarnings() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinnings() * entry.getValue())
                .sum();
    }

    public double calculateEarningsRate(int purchaseAmount) {
        long totalEarnings = getTotalEarnings();
        return (double) totalEarnings / purchaseAmount;
    }

}
