package lotto;


import java.util.Arrays;

public class WinningStatistics {

    private static final int PERCENTAGE = 100;

    private final WinningCounts winningCounts;
    private final PaidAmount paidAmount;

    public WinningStatistics(final WinningCounts winningCounts, final PaidAmount paidAmount) {
        this.winningCounts = winningCounts;
        this.paidAmount = paidAmount;
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / paidAmount.getPaidAmount() * PERCENTAGE;
    }

    private long calculateTotalPrize() {
        return Arrays.stream(WinningRank.values())
                .mapToLong(rank -> rank.getPrize() * winningCounts.getCount(rank))
                .sum();
    }
}

