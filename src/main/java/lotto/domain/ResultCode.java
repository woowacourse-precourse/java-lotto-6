package lotto.domain;

public enum ResultCode {

    FIFTH(3, false, 5, 5000),
    FOURTH(4, false, 4, 50000),
    THIRD(5, false, 3, 1500000),
    SECOND(5, true, 2, 30000000),
    FIRST(6, false, 1, 2000000000);

    public int matchCount;
    public boolean bonusMatch;
    public int rank;
    public int prize;

    ResultCode(int matchCount, boolean bonusMatch, int rank, int prize) {
        this.bonusMatch = bonusMatch;
        this.matchCount = matchCount;
        this.rank = rank;
        this.prize = prize;
    }
}
