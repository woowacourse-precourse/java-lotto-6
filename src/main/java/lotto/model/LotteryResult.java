package lotto.model;

import java.text.DecimalFormat;
import java.util.Map;

public class LotteryResult {

  private static final String DECIMAL_FORMAT = "#,##0.0";

  private Map<WinningMoney, Integer> store;

  public LotteryResult(Map<WinningMoney, Integer> store) {
    this.store = store;
  }

  public String getProfitPercentage(PurchaseMoney purchaseMoney) {
    double profitPercentage = (double) calculateProfit() / purchaseMoney.getPurchaseMoney();
    System.out.println(profitPercentage);

    return new DecimalFormat(DECIMAL_FORMAT).format(profitPercentage);
  }

  private long calculateProfit() {
    long sum = 0;
    for (WinningMoney key : WinningMoney.values()) {
      sum += calculateMatches(key);
    }

    System.out.println(sum);
    return sum;
  }

  private long calculateMatches(WinningMoney winningMoney) {
    if (store.containsKey(winningMoney)) {
      return WinningMoney.calculateMoney(winningMoney, store.get(winningMoney));
    }

    return 0;
  }
}
