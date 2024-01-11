package lotto.util;

public enum WinningCheck {
  LOSE("0", 0),
  FIFTH_PRIZE("5,000", 3),
  FOURTH_PRIZE("50,000", 4),
  THIRD_PRIZE("1,500,000", 5, false),
  SECOND_PRIZE("30,000,000", 5, true),
  FIRST_PRIZE("2,000,000,000", 6);

  private final String prizeAmount;
  private final int matchingCount;
  private final boolean hasBonus;

  WinningCheck(String prizeAmount, int matchingCount) {
    this.prizeAmount = prizeAmount;
    this.matchingCount = matchingCount;
    this.hasBonus = false;
  }

  WinningCheck(String prizeAmount, int matchingCount, boolean hasBonus) {
    this.prizeAmount = prizeAmount;
    this.matchingCount = matchingCount;
    this.hasBonus = hasBonus;
  }

  public String getPrizeAmount() {
    return prizeAmount;
  }

  public int getMatchingCount() {
    return matchingCount;
  }

  public boolean hasBonus() {
    return hasBonus;
  }

  public static WinningCheck getPrize(int matchCount, boolean bonusMatch) {
    if (matchCount == 6) {
      return FIRST_PRIZE;
    }
    if (matchCount == 5) {
      return bonusMatch ? SECOND_PRIZE : THIRD_PRIZE;
    }
    if (matchCount == 4) {
      return FOURTH_PRIZE;
    }
    if (matchCount == 3) {
      return FIFTH_PRIZE;
    }
    return LOSE;
  }
}
