package lotto.service;
import java.util.List;
import lotto.constant.Prize;

public class ProfitCalculationService {

  public double calculateProfitRate(int purchaseAmount, List<Integer> winningRanks) {
    int totalPrize = calculateTotalPrize(winningRanks);
    return calculateProfit(purchaseAmount, totalPrize);
  }

  private int calculateTotalPrize(List<Integer> winningRanks) {
    int totalPrize = 0;
    for (int rank : winningRanks) {
      totalPrize += Prize.values()[rank - 1].getPrizeMoney();
    }
    return totalPrize;
  }

  private double calculateProfit(int purchaseAmount, int totalPrize) {
    return (double) totalPrize / purchaseAmount;
  }
}