package lotto.domain;

import java.util.List;
import lotto.util.enumerator.WinningAmount;

public class Profit {
    public long calculateTotalProfitAmount(List<WinningAmount> winningAmount) {
        long result = 0L;
        for (WinningAmount amount : winningAmount) {
            result += amount.getAmount();
        }
        return result;
    }

    public double calculateTotalProfitRate(double profitAmount, double purchaseAmount) {
        double profitRate = calculateRate(profitAmount, purchaseAmount);
        return calculateRoundedRate(profitRate);
    }

    private double calculateRate(double profitAmount, double purchaseAmount) {
        return profitAmount / purchaseAmount * 100.0;
    }

    private double calculateRoundedRate(double profitRate) {
        return Math.round(profitRate * 100) / 100.0;
    }
}
