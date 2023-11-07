package lotto;


import java.util.Arrays;

public class WinningStatistics {

    private static final int PERCENTAGE = 100;

    private final WinningRankCounts winningRankCounts;
    private final PaidAmount paidAmount;

    public WinningStatistics(final WinningRankCounts winningRankCounts, final PaidAmount paidAmount) {
        this.winningRankCounts = winningRankCounts;
        this.paidAmount = paidAmount;
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / paidAmount.getPaidAmount() * PERCENTAGE;
    }

    private long calculateTotalPrize() {
        return Arrays.stream(WinningRank.values())
                .mapToLong(rank -> rank.getPrize() * winningRankCounts.getCount(rank))
                .sum();
    }
}

