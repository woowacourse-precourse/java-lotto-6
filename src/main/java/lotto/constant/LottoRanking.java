package lotto.constant;

public enum LottoRanking {
    FIRST(6, 2000000000L),
    SECOND(5, 30000000L),
    THIRD(5, 1500000L),
    FOURTH(4, 50000L),
    FIFTH(3, 5000L);

    private final int sameCount;
    private final long prize;

    LottoRanking(int sameCount, long prize) {
        this.sameCount = sameCount;
        this.prize = prize;
    }

    public int getSameCount() {
        return sameCount;
    }

    public long getPrize() {
        return prize;
    }
}
