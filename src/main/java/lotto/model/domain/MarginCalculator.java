package lotto.model.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import lotto.model.domain.constants.PrizeConstants;

public class MarginCalculator {
    private final double margin;

    public MarginCalculator(int money, WinningConfirm winningConfirm) {
        this.margin = totalMargin(money, winningConfirm);
    }

    private double totalMargin(int money, WinningConfirm winningConfirm) {
        BigDecimal bd = new BigDecimal(calculateProfitMargin(winningConfirm) / money * 100.0);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private double calculateProfitMargin(WinningConfirm winningConfirm) {
        double profit = 0;
        Map<PrizeConstants, Integer> winningCounts = winningConfirm.getWinningCounts();
        for (PrizeConstants prize : winningCounts.keySet()) {
            profit += winningCounts.get(prize) * prize.getPrize();
        }

        return profit;
    }


    public double getMargin() {
        return this.margin;
    }
}