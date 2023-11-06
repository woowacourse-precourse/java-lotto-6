package lotto;

import java.util.List;

public class ProfitCalculator {
    public double calculateProfitRate(int purchaseAmount, List<Rank> results) {
        double totalPrizeMoney = 0;
        for (Rank rank : results) {
            totalPrizeMoney += rank.getPrizeMoney();
        }
        double totalPurchaseAmount = purchaseAmount;
        return (totalPrizeMoney / totalPurchaseAmount) * 100;
    }
}