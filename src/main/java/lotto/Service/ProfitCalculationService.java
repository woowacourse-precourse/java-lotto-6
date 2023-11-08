package lotto.Service;

import java.util.List;

public class ProfitCalculationService {

  private static final int[] PRIZE_MONEY = {0, 0, 5000, 50000, 1500000, 30000000, 2000000000};

  public double calculateProfitRate(int countOfPurchase, int countOfWinning) {
    int expenditure = countOfPurchase * 1000;
    int prize = PRIZE_MONEY[countOfWinning];
    return calculateRate(expenditure, prize);
  }

  private double calculateRate(int expenditure, int prize) {
    return ((double) prize - expenditure) / expenditure * 100;
  }
}
