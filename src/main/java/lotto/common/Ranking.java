package lotto.common;

public enum Ranking {
    FIFTH(5, "5000", 3),
    FOURTH(4, "50000", 4),
    THIRD(3, "1500000", 5),
    SECOND(2, "30000000", 5),
    FIRST(1, "2000000000", 6),
    NONE(0, "0", 0);


    private int rank;
    private String prize;
    private int matchCount;


    Ranking(int rank, String prize, int matchCount) {
        this.rank = rank;
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getRank() {
        return rank;
    }

    public String getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
