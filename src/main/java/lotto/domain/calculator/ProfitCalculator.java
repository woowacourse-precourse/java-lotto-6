package lotto.domain.calculator;

import java.util.Map;
import lotto.constant.Rank;

public class ProfitCalculator {

    private static final int PERCENTAGE_FACTOR = 100;

    public double getProfitRate(int purchaseAmount, Map<Rank, Integer> results) {
        long totalWinningAmount = calculateTotalWinningAmount(results);
        return calculateRate(purchaseAmount, totalWinningAmount);
    }

    private long calculateTotalWinningAmount(Map<Rank, Integer> results) {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    private double calculateRate(int purchaseAmount, long totalWinningAmount) {
        return (double) totalWinningAmount / purchaseAmount * PERCENTAGE_FACTOR;
    }
}
