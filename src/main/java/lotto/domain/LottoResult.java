package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result = new HashMap<>();

    public void addRank(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public int getCount(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public long getTotalPrizeMoney() {
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    public Double calculateProfitRate(int input) {
        return (double) getTotalPrizeMoney() / input;
    }
}
