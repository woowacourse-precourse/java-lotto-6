package lotto.domain;

import java.util.List;

public class TotalWinning {
    private final int totalAmount;
    private final double totalReturn;

    public TotalWinning(LottoPurchase lottoPurchase, WinningResult winningResult) {
        this.totalAmount = winningResult.calculateTotalAmount();
        this.totalReturn = (double) totalAmount / lottoPurchase.getAmount();
    }

    public int getTotalAmount() {return totalAmount;}
    public double getTotalReturn() {
        return totalReturn;
    }
}