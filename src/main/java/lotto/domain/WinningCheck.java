package lotto.domain;

public enum WinningCheck {
  LOSE(0, 0),
  FIFTH_PRIZE(5_000, 3),
  FOURTH_PRIZE(50_000, 4),
  THIRD_PRIZE(1_500_000, 5, false),
  SECOND_PRIZE(30_000_000, 5, true),
  FIRST_PRIZE(2_000_000_000, 6);

  private final int prizeAmount;
  private final int matchingCount;
  private final boolean hasBonus;

  WinningCheck(int prizeAmount, int matchingCount) {
    this.prizeAmount = prizeAmount;
    this.matchingCount = matchingCount;
    this.hasBonus = false;
  }

  WinningCheck(int prizeAmount, int matchingCount, boolean hasBonus) {
    this.prizeAmount = prizeAmount;
    this.matchingCount = matchingCount;
    this.hasBonus = hasBonus;
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

  public int getPrizeAmount() {
    return prizeAmount;
  }

  public int getMatchingCount() {
    return matchingCount;
  }

  public boolean hasBonus() {
    return hasBonus;
  }
}
