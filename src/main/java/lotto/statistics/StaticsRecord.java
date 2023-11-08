package lotto.statistics;

import java.util.Objects;

public record StaticsRecord(int winningNumber, int prize, int matchCount) {

  public static StaticsRecord of(int win, int winningMoney, int matchCount) {
    return new StaticsRecord(win, winningMoney, matchCount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StaticsRecord that)) {
      return false;
    }
    return winningNumber == that.winningNumber && prize == that.prize;
  }

  @Override
  public int hashCode() {
    return Objects.hash(winningNumber, prize);
  }
}
