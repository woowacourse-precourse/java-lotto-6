package lotto.model;

import java.util.List;

public class LottoResult {

  public static int lottoPrizeCalculator  (List<Integer> rank) {
    int currentCount = 0;
    int prize = 0;
    for (Ranking ranking : Ranking.values()) {
      int winningAmount = ranking.getWinningAmount();
      int count = rank.get(currentCount);
      currentCount++;
      prize += winningAmount*count;
    }
    return prize;
  }

  public static double profitabilityCalculator(int money, int prize) {
    return ((double)(prize) / (double) money) * 100.0;
  }

  public static String calculateRoundedProfitabilityWithCommas(double value) {
    double roundedValue = Math.round(value * 100.0) / 100.0;
    return String.format("%,.1f", roundedValue);
  }

}
