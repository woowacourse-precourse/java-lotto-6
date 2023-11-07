package lotto;

import java.util.Map;

public record WinningStatistics(LottoAmount lottoAmount, Map<Ranking, Integer> rankingNumber) {
    public double getReturnRate() {
        return Math.round(calculateReturnRate() * 100.0) / 100.0;
    }

    private double calculateReturnRate() {
        int amount = lottoAmount.getAmount();
        return (double) getTotalPrize() / amount * 100;
    }

    private int getTotalPrize() {
        return rankingNumber.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
