package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();

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

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public long getTotalAmount() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinnings() * entry.getValue())
                .sum();
    }

    public double getProfitPercentage(int purchasePrice) {
        long totalAmount = getTotalAmount();
        System.out.println(totalAmount);
        return (double) totalAmount / purchasePrice;
    }
}
