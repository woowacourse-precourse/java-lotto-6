package lotto.model;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000),
    NO_RANK(0, 0);

    private final int prize;
    private final int hitCount;

    Rank(int hitCount, int prize) {
        this.hitCount = hitCount;
        this.prize = prize;
    }

    public static Rank getRank(int hitCount, boolean isBonusNumberIncluded) {
        if (isBonusNumberIncluded && hitCount == FIFTH.hitCount) {
            return Rank.FIFTH;
        }

        if (hitCount == FORTH.hitCount) {
            return Rank.FORTH;
        }

        if (hitCount == THIRD.hitCount) {
            return Rank.THIRD;
        }

        if (hitCount == SECOND.hitCount) {
            return Rank.SECOND;
        }

        if (hitCount == FIRST.hitCount) {
            return Rank.FIRST;
        }

        return Rank.NO_RANK;
    }

    public int getPrize() {
        return prize;
    }

    public int getHitCount() {
        return hitCount;
    }
}