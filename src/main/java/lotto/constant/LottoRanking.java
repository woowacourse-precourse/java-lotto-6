package lotto.constant;

public enum LottoRanking {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L);

    private final int sameCount;
    private final boolean isBonusCorrect;
    private final long prize;

    LottoRanking(int sameCount, boolean isBonusNumberCorrect, long prize) {
        this.sameCount = sameCount;
        this.isBonusCorrect = isBonusNumberCorrect;
        this.prize = prize;
    }

    public int getSameCount() {
        return sameCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isBonusCorrect() {
        return isBonusCorrect;
    }
}
