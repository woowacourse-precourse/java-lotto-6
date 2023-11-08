package lotto;

import java.util.List;

public class Profit {
    public double calculateProfit(List<Integer> result, int numberOfLotto) {
        int totalPrize = calculateTotalPrize(result);
        int totalCost = calculateTotalCost(numberOfLotto);

        double profitPercentage = calculateProfitPercentage(totalPrize, totalCost);
        return profitPercentage;
    }

    private int calculateTotalPrize(List<Integer> result) {
        return result.get(WinningGrade.THIRD.getCount()) * 5000 +
                result.get(WinningGrade.FOURTH.getCount()) * 50000 +
                result.get(WinningGrade.FIFTH.getCount()) * 1500000 +
                result.get(WinningGrade.FIFTH_BONUS.getCount()) * 30000000 +
                result.get(WinningGrade.SIXTH.getCount()) * 2000000000;
    }

    private int calculateTotalCost(int numberOfLotto) {
        return numberOfLotto * 1000;
    }

    private double calculateProfitPercentage(int totalPrize, int totalCost) {
        return (double) totalPrize / totalCost * 100;
    }

    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}


