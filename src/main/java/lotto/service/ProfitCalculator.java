package lotto.service;

import lotto.Lotto;

public class ProfitCalculator {
    public double calculateProfit(int totalPurchased, int totalPrize) {
        if (totalPurchased == 0) {
            return 0.0;
        }

        double profit = (double) totalPrize / totalPurchased * 100;

        return Math.round(profit * 10.0) / 10.0;
    }
}
