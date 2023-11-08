package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Map.Entry;

public record WinningStatistics(LottoAmount lottoAmount, Map<Ranking, Integer> rankingNumbers) {
    public BigDecimal getReturnRate() {
        BigDecimal returnRate = BigDecimal.valueOf(calculateReturnRate());
        return returnRate.setScale(1, RoundingMode.HALF_UP);
    }

    private double calculateReturnRate() {
        int amount = lottoAmount.amount();
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
