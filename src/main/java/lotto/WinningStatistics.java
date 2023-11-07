package lotto;

import java.util.Map;

public record WinningStatistics(LottoAmount lottoAmount, Map<Ranking, Integer> rankingNumber) {
    public double getReturnRate() {
        int amount = lottoAmount.getAmount();
        return (double) (getTotalPrize() - amount) / amount * 100;
    }

    private int getTotalPrize() {
        return rankingNumber.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
