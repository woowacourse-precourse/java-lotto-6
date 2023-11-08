package lotto.LottoModel;

public enum LottoRank {
    All(6, 2000000000),
    FIVEANDBONUS(5, 30000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000),
    NONE(0, 0);

    public int getPrize() {
        return prize;
    }

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }
}
