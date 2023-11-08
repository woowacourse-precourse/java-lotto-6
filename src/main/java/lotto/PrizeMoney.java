package lotto;

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
    for (int i = 3; i <= 6; i++) {
      int prizeAmount = Prize.values()[i - 3].getAmount(); // i에 따른 Prize를 가져옵니다.
      System.out.println(i + "개 일치 (" + prizeAmount + "원) - " + results[i - 3] + "개");
    }
  }
}
