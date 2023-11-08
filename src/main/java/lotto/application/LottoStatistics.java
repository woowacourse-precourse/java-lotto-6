package lotto.application;

import static lotto.contents.ContentNumbers.PERCENTAGE;

import lotto.domain.LottoResult;

public class LottoStatistics {
    private final LottoResult lottoResult;
    private final int totalSpent;

    public LottoStatistics(LottoResult lottoResult, int totalSpent) {
        this.lottoResult = lottoResult;
        this.totalSpent = totalSpent;
    }

    public double calculateEarningsRate() {
        double totalEarnings = calculateTotalEarnings();
        return (totalEarnings / totalSpent) * PERCENTAGE.getNumber();
    }

    private double calculateTotalEarnings() {
        long totalEarnings = lottoResult.getPrizeCount().entrySet().stream()
                .mapToLong(prize -> (long) prize.getKey().getPrizeMoney() * prize.getValue())
                .sum();
        return totalEarnings;
    }
}
