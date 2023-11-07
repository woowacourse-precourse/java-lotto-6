package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public record WinningStatistics(LottoAmount lottoAmount, Map<Ranking, Integer> rankingNumbers) {
    public double getReturnRate() {
        return Math.round(calculateReturnRate() * 10.0) / 10.0;
    }

    private double calculateReturnRate() {
        int amount = lottoAmount.getAmount();
        return (double) getTotalPrize() / amount * 100;
    }

    private int getTotalPrize() {
        return rankingNumbers.entrySet().stream()
                .mapToInt(this::getPrizePerRankingCount)
                .sum();
    }

    private int getPrizePerRankingCount(Entry<Ranking, Integer> rankingNumber) {
        int prize = rankingNumber.getKey().getPrize();
        int count = rankingNumber.getValue();

        return prize * count;
    }
}
