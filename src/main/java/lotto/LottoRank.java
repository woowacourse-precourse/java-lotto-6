package lotto;

public enum LottoRank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000, true),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  NONE(0, 0);

  private final int matchCount;
  private final int prize;
  private final boolean bonusMatch;

  LottoRank(int matchCount, int prizeMoney) {
    this(matchCount, prizeMoney, false);
  }

  LottoRank(int matchCount, int prize, boolean bonusMatch) {
    this.matchCount = matchCount;
    this.prize = prize;
    this.bonusMatch = bonusMatch;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrize() {
    return prize;
  }

  public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
    for (LottoRank rank : LottoRank.values()) {
      if (matchCount == rank.getMatchCount() && (!rank.isBonusMatch() || bonusMatch)) {
        return rank;
      }
    }
    return NONE;
  }

  public boolean isBonusMatch() {
    return bonusMatch;
  }
}