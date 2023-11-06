package lotto;


import java.util.Arrays;

public class WinningStatistics {
    private final WinningTicketCounts winningCounts;
    private final PaidAmount paidAmount;

    public WinningStatistics(final WinningTicketCounts winningCounts, final PaidAmount paidAmount) {
        this.winningCounts = winningCounts;
        this.paidAmount = paidAmount;
    }

    public double calculateProfitRate() {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / paidAmount.getPaidAmount();
    }

    private long calculateTotalPrize() {
        return Arrays.stream(WinningRank.values())
                .mapToLong(rank -> rank.getPrize() * winningCounts.getCount(rank))
                .sum();
    }
}

