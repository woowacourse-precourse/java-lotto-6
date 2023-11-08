package lotto.statistics.calculatewinning;

import java.util.Arrays;
import java.util.Optional;

public enum Win {
  FIFTH(3),

  FOURTH(4),

  SECONDORTHIRD(5),

  FIRST(6);
  private final int matchCount;

  Win(int matchCount) {
    this.matchCount = matchCount;
  }

  public static boolean isWin(int matchCount) {
    return matchCount >= 3;
  }

  public static Optional<Win> findWin(int matchCount) {
    return Arrays.stream(Win.values())
        .filter(win -> win.getMatchCount() == matchCount)
        .findFirst();
  }

  public int getMatchCount() {
    return matchCount;
  }
}
