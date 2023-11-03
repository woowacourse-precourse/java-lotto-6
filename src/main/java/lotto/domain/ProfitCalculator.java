package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfitCalculator {
    private final LotteryChecker lotteryChecker;
    private int totalSum;

    public ProfitCalculator(LotteryChecker lotteryChecker) {
        this.lotteryChecker = lotteryChecker;
    }

    public void calculate(List<Integer> prize) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2000000000, 30000000, 1500000, 50000, 5000));
        for (int i = prize.size() - 1; i >= 0; i--) {
            totalSum += price.get(i) * prize.get(i);
        }
    }

    public int getTotalSum() {
        return totalSum;
    }

    public double earnRate(int totalSum, int lottoPurchaseAmount) {
        double earnRate = (double) totalSum / lottoPurchaseAmount * 100;
        return Math.round(earnRate * 100.0) / 100.0;
    }
}
