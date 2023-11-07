package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> results;

    public LottoResult() {
        this.results = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
    }

    public void addWinningRank(LottoRank rank) {
        results.merge(rank, 1, Integer::sum);
    }

    public int getCountOfRank(LottoRank rank) {
        return results.getOrDefault(rank, 0);
    }

    public double calculateTotalEarnings() {
        return results.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }
}