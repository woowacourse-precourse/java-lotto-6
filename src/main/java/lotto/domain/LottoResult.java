package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoEnum.LottoRank, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void add(LottoEnum.LottoRank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
    public int getCount(LottoEnum.LottoRank rank) {
        return result.getOrDefault(rank, 0);
    }
    public double calculateEarningsRate(int purchaseAmount) {
        double totalPrize = result.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
        return totalPrize / purchaseAmount;
    }
}
