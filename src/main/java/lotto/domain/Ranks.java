package lotto.domain;

public enum Ranks {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchingNumbers;
    private final int rankPrize;
    private int count;

    Ranks(int matchingNumbers, int rankPrize) {
        this.matchingNumbers = matchingNumbers;
        this.rankPrize = rankPrize;
        this.count = 0;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getRankPrize() {
        return rankPrize;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public static Ranks getRank(int matchingNumbers,boolean hasBonusBall) {
        for (Ranks rank : values()) {
            if (rank.matchingNumbers == matchingNumbers&&(rank != SECOND || hasBonusBall)) {
                rank.increaseCount();
                return rank;
            }
        }
        return NONE;
    }
}
