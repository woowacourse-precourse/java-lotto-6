package lotto.model;

public enum LottoRank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    NO_RANK(0);

    private final int prize;

    LottoRank(int prize) {
        this.prize = prize;
    }

    public static LottoRank getRank(int hitNumberCount, boolean isBonusNumberIncluded) {
        if (isBonusNumberIncluded && hitNumberCount == 5) {
            return LottoRank.FIFTH;
        }

        if (hitNumberCount == 4) {
            return LottoRank.FORTH;
        }

        if (hitNumberCount == 3) {
            return LottoRank.THIRD;
        }

        if (hitNumberCount == 2) {
            return LottoRank.SECOND;
        }

        if (hitNumberCount == 1) {
            return LottoRank.FIRST;
        }

        return LottoRank.NO_RANK;
    }

    public int getPrize() {
        return prize;
    }
}