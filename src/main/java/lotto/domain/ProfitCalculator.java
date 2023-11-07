package lotto.domain;

import java.util.Map;
import lotto.service.PurchaseService;

public class ProfitCalculator {
    private final int PERCENTAGE = 100;

    public double calculateProfitRateInPercentage(Map<Rank, Integer> result) {
        long usedMoney = calculateUsedAmountOfMoney(result);
        long earnedMoney = calculateEarnedMoney(result);
        return (double) earnedMoney / usedMoney * PERCENTAGE;
    }

    private long calculateUsedAmountOfMoney(Map<Rank, Integer> result) {
        int lottoCount = result.size();
        return (long) lottoCount * PurchaseService.LOTTO_PRICE;
    }

    private long calculateEarnedMoney(Map<Rank, Integer> result) {
        return result.keySet()
                .stream()
                .map(rank -> rank.calculateTotalPrizeMoney(result.get(rank)))
                .reduce(0L, Long::sum);
    }
}
