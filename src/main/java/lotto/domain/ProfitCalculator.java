package lotto.domain;

import java.util.Map;

public class ProfitCalculator {

    public ProfitCalculator() {
    }

    public double calculateProfitRate(int purchaseAmount, Map<Rank, Integer> results) {
        long totalWinningAmount = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningMoney() * entry.getValue())
                .sum();

        return (double) totalWinningAmount / purchaseAmount * 100.0;
    }
}
