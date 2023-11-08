package lotto;

import java.util.List;
public class Profit {
    public double calculateProfit(List<Integer> result){
        int totalPrize = result.get(WinningGrade.THIRD.getCount()) * 5000 +
                         result.get(WinningGrade.FOURTH.getCount()) * 50000 +
                         result.get(WinningGrade.FIFTH.getCount()) * 1500000 +
                         result.get(WinningGrade.FIFTH_BONUS.getCount()) * 30000000 +
                         result.get(WinningGrade.SIXTH.getCount()) * 2000000000;
        int totalCost = result.stream().mapToInt(i -> i).sum() * 1000; // 가정: 각 로또 가격은 1,000원

        double profitPercentage = ((double) totalPrize - totalCost) / totalCost * 100;
        return profitPercentage;
    }
    public void printProfit(double profit){
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.");
    }
}
