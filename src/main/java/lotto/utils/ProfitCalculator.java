package lotto.utils;

import lotto.model.LottoRank;

import java.util.Map;

public class ProfitCalculator {

    public static double calculateProfitRate(Map<LottoRank, Integer> results, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(results);
        double profitRate = (totalPrize / (double) purchaseAmount) * 100;
        return roundOff(profitRate);
    }

    private static long calculateTotalPrize(Map<LottoRank, Integer> results) {
        return results.entrySet().stream()
                .filter(entry -> entry.getKey() != LottoRank.NONE)
                .mapToLong(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }

    private static double roundOff(double value) {
        return Math.round(value * 10.0) / 10.0;
    }
}
