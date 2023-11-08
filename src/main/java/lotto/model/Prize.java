package lotto.model;

public enum Prize {
  FIRST(0, 6, 2000000000),
  SECOND(1, 5, 30000000),
  THRID(2, 5, 1500000),
  FOURTH(3, 4, 50000),
  FIFTH(4, 3, 5000);

  private final int index;
  private final int matchingCount;
  private final int prizeMoney;


  Prize(int index, int matchingCount, int prizeMoney) {
    this.index = index;
    this.matchingCount = matchingCount;
    this.prizeMoney = prizeMoney;
  }

  public int getIndex() {
    return index;
  }

  public int getMatchingCount() {
    return matchingCount;
  }

  public int getPrizeMoney() {
    return prizeMoney;
  }
}
