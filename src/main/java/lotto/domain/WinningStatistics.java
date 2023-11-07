package lotto.domain;

import java.util.Map;
import lotto.domain.LottoAmount;
import lotto.domain.Ranking;

public record WinningStatistics(LottoAmount lottoAmount, Map<Ranking, Integer> rankingNumber) {
    public double getReturnRate() {
        return Math.round(calculateReturnRate() * 10.0) / 10.0;
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
