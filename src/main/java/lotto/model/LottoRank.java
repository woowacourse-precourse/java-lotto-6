package lotto.model;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCnt;
    private final int prize;

    LottoRank(int matchCnt, int prize) {
        this.matchCnt = matchCnt;
        this.prize = prize;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getPrize() {
        return prize;
    }

}
