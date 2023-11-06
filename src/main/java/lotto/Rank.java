package lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank valueOf(int matchCount, boolean hasBonusNumber) {
        if (matchCount == 3) {
            return Rank.FIFTH;
        } else if (matchCount == 4) {
            return Rank.FOURTH;
        } else if (matchCount == 5 && !hasBonusNumber) {
            return Rank.THIRD;
        } else if (matchCount == 5 && hasBonusNumber) {
            return Rank.SECOND;
        } else if (matchCount == 6) {
            return Rank.FIRST;
        }

        return Rank.MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}