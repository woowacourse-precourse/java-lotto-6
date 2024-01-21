package lotto.service;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCheck;

public class LottoProfitRateCalculator {

  private static final int PERCENTAGE_FACTOR = 100;

  public double calculateProfitRate(PurchaseAmount purchaseAmount,
      Map<WinningCheck, Integer> result) {
    double totalPrize = result.entrySet().stream()
        .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
        .sum();

    double profitRate = (totalPrize / purchaseAmount.getPurchaseAmount()) * PERCENTAGE_FACTOR;
    DecimalFormat df = new DecimalFormat("#.##");
    return Double.parseDouble(df.format(profitRate));
  }
}
