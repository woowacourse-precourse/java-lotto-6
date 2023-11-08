package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
    private final int purchaseAmount;

    public LottoResult(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
    }

    public void updateResult(LottoRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public Map<LottoRank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public double calculateProfitRatio() {
        long totalPrizeMoney = results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        return ((double) totalPrizeMoney)  / purchaseAmount * 100;
    }
}
