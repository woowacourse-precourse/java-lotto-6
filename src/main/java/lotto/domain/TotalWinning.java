package lotto.domain;

public class TotalWinning {
    private final long totalAmount;
    private final double totalReturn;

    private TotalWinning(LottoPurchase lottoPurchase, WinningResult winningResult) {
        this.totalAmount = winningResult.calculateTotalAmount();
        this.totalReturn = (double) totalAmount / lottoPurchase.getAmount();
    }

    public static TotalWinning compare(LottoPurchase lottoPurchase, WinningResult winningResult) {
        return new TotalWinning(lottoPurchase, winningResult);
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public double getTotalReturn() {
        return totalReturn;
    }
}