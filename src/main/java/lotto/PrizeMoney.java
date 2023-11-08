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
}
