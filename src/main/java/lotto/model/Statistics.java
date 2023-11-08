package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Statistics {

    private final int totalAmount;
    private final List<MatchResult> matchResults;

    public Statistics(int totalAmount, List<MatchResult> matchResults) {
        this.totalAmount = totalAmount;
        this.matchResults = matchResults;
    }

    public float evaluateTotalProfit() {
        Map<MatchResult, Integer> counts = calculateMatchCounts();

        float totalEarningPrize = calculateTotalEaringPrize(counts);
        float totalProfit = getProfitRate(totalEarningPrize);
        return totalProfit;
    }

    private Map<MatchResult, Integer> calculateMatchCounts() {
        return matchResults.stream()
            .collect(Collectors.toMap(Function.identity(), matchResult -> 1, Integer::sum));
    }

    private int calculateTotalEaringPrize(Map<MatchResult, Integer> matchCounts) {
        return matchCounts.entrySet().stream()
            .mapToInt(entry -> entry.getValue() * new PrizeMoney().getPrizeMoney().getOrDefault(entry.getKey(), 0))
            .sum();
    }

    private float getProfitRate(float totalWinnings) {
        float profitRate = (totalWinnings / totalAmount) * 100;
        return profitRate;
    }
}
