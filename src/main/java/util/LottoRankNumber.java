package util;

public enum LottoRankNumber {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    OTHER(6);

    private final int rankNumber;

    LottoRankNumber(int rankNumber) {
        this.rankNumber = rankNumber;
    }

    public int get() {
        return rankNumber;
    }
}
