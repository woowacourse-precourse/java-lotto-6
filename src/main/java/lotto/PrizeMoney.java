package lotto;

import java.text.NumberFormat;
import java.util.Locale;

public class PrizeMoney {
  public enum Prize {
    MATCH_3(3, 5000), MATCH_4(4, 50000), MATCH_5(5, 1500000), MATCH_5_WITH_BONUS(5,
        30000000), MATCH_6(6, 2000000000);

    private final int matchingNumbers;
    private final int amount;


    Prize(int matchingNumbers, int amount) {
      this.matchingNumbers = matchingNumbers;
      this.amount = amount;
    }

    public int getMatchingNumbers() {
      return matchingNumbers;
    }

    public int getAmount() {
      return amount;
    }
  }

  public static void printResults(int[] results) {
    System.out.println("당첨 통계");
    System.out.println("---");

    // 3개, 4개 일치
    for (int i = 0; i <= 2; i++) {
      int prizeAmount = Prize.values()[i].getAmount();
      String formattedAmount = NumberFormat.getNumberInstance(Locale.US).format(prizeAmount);
      System.out.println((i + 3) + "개 일치 (" + formattedAmount + "원) - " + results[i] + "개");
    }

    int prizeAmount = Prize.values()[3].getAmount();
    String formattedAmount = NumberFormat.getNumberInstance(Locale.US).format(prizeAmount);
    System.out.println("5개 일치, 보너스 볼 일치 (" + formattedAmount + "원) - " + results[4] + "개");

    prizeAmount = Prize.values()[4].getAmount();
    System.out.println("6개 일치 (" + formattedAmount + "원) - " + results[3] + "개");
  }



}
