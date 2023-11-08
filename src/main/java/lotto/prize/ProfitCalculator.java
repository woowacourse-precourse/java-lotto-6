package lotto.prize;

import java.util.List;

public class ProfitCalculator {
    public double calculateProfit(List<MatchResult> matchResults, int spentAmount) {
        int totalPrize = matchResults.stream()
                .mapToInt(result -> result.getRank().getPrizeMoney())
                .sum();

        return ((double) totalPrize / spentAmount) * 100;
    }
}