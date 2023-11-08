package lotto.statistics.calculatewinning;

import java.util.Objects;

public record WinningRecord(Ranking ranking, int matchCount) implements Comparable<WinningRecord> {

  public WinningRecord plusMatchCount(WinningRecord winningRecord) {
    if (!this.ranking.equals(winningRecord.ranking)) {
      return this;
    }
    return new WinningRecord(ranking, this.matchCount + winningRecord.matchCount);
  }

  public int winningMoney(){
    return ranking.getWinningMoney() * matchCount;
  }

  @Override
  public int compareTo(WinningRecord o) {
    return ranking.compareTo(o.ranking);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WinningRecord that)) {
      return false;
    }
    return Objects.equals(ranking, that.ranking);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ranking);
  }
}
