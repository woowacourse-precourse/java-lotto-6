package lotto.service;

import java.util.List;
import lotto.constant.Prize;

public class ProfitCalculationService {
  public static final int TICKET_PRICE = 10;
  public double calculateProfitRate(int purchaseAmount, List<Integer> winningRanks) {
    int totalPrize = calculateTotalPrize(winningRanks);
    return calculateProfit(purchaseAmount, totalPrize);
  }

  private int calculateTotalPrize(List<Integer> winningRanks) {
    int totalPrize = 0;
    int i = 0;
    winningRanks.remove(winningRanks.size() - 1); // 꽝인 복권들 제외
    for (int rank : winningRanks) {
      totalPrize += Prize.values()[i].getPrizeMoney() * rank;
      i++;
    }
    return totalPrize;
  }

  private double calculateProfit(int purchaseAmount, int totalPrize) {
    return (double) totalPrize / (purchaseAmount * TICKET_PRICE);
  }
}