package lotto.domain.model.result;


import lotto.domain.model.lotto.PaidAmount;
import java.util.Arrays;

public class ProfitRateCalculator {

    private static final int PERCENTAGE = 100;

    public double calculate(final WinningRankCounts winningRankCounts, final PaidAmount paidAmount) {
        long totalPrize = calculateTotalPrize(winningRankCounts);
        return (double) totalPrize / paidAmount.getPaidAmount() * PERCENTAGE;
    }

    private long calculateTotalPrize(final WinningRankCounts winningRankCounts) {
        return Arrays.stream(WinningRank.values())
                .mapToLong(rank -> rank.getPrize() * winningRankCounts.getCount(rank))
                .sum();
    }
}

