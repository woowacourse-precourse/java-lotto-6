package lotto.statistics.calculatewinning;

import java.util.Arrays;

public enum Ranking {
  FIFTH(Win.FIFTH, false, 5_000),
  FOURTH(Win.FOURTH, false, 50_000),
  THIRD(Win.SECONDORTHIRD, false, 1_500_000),
  SECOND(Win.SECONDORTHIRD, true, 30_000_000),
  FIRST(Win.FIRST, false, 2_000_000_000);
  private final Win rankMatchCount;

  private final boolean bonusNumber;
  private final int winningMoney;

  Ranking(Win rankMatchCount, boolean bonusNumber, int winningMoney) {
    this.rankMatchCount = rankMatchCount;
    this.bonusNumber = bonusNumber;
    this.winningMoney = winningMoney;
  }

  public static Ranking findRanking(Win matchCount, boolean bonusNumber) {
    return Arrays.stream(Ranking.values())
        .filter(
            ranking -> ranking.rankMatchCount == matchCount && ranking.bonusNumber == bonusNumber)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("해당하는 등수가 없습니다."));
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public Win getRankMatchCount() {
    return rankMatchCount;
  }
}
