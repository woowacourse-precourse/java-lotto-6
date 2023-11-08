package lotto.model;

public enum Rank {
    NO_RANK(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int prize;
    private final int hitCount;

    Rank(int hitCount, int prize) {
        this.hitCount = hitCount;
        this.prize = prize;
    }

    public static Rank getRank(int hitCount, boolean isBonusNumberIncluded) {
        if (isBonusNumberIncluded && hitCount == SECOND.hitCount) {
            return Rank.SECOND;
        }

        for (Rank rank : values()) {
            if (hitCount == rank.getHitCount()) return rank;
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