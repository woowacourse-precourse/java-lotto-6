package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<MatchCount, Integer> result;

    public LottoResult() {
        result = new HashMap<>();
        Arrays.stream(MatchCount.values())
            .forEach(matchCount -> {
                result.put(matchCount, 0);
            });
    }

    public void addResult(final MatchCount matchCount) {
        result.put(matchCount, result.get(matchCount) + 1);
    }

    public int getCount(final MatchCount matchCount) {
        return result.get(matchCount);
    }

    public double calculateEarningsRate(final int purchaseAmount) {
        int totalEarnings = result.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
            .sum();
        double earningsRate = ((double) totalEarnings / purchaseAmount) * 100;
        BigDecimal bd = new BigDecimal(Double.toString(earningsRate)).setScale(2,
            RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
