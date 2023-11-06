package lotto.enums;

public enum LottoRank {
    FIFTH(5, 3, 5000),
    FOURTH(4, 4, 50000),
    THIRD(3, 5, 1500000),
    SECOND(2, 5, 30000000),
    FIRST(1, 6, 2000000000);

    private final int rank;
    private final int matchCount;
    private final int prize;

    LottoRank(int rank, int matchCount, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getRank(){
        return rank;
    }
    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
