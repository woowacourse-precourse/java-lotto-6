package lotto.model;

public enum Ranking {
  FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
  SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
  THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
  FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
  FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
  MISS(0, 0, "");

  private final int countOfMatch;
  private final int winningAmount;
  private final String message;

  Ranking(final int countOfMatch, final int winningAmount, final String message) {
    this.countOfMatch = countOfMatch;
    this.winningAmount = winningAmount;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public int getWinningAmount() {
    return winningAmount;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }
}
