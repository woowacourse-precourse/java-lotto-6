package lotto.domain;

public enum Rank {
    NO_RANK0(0, 0L, "0"),
    NO_RANK1(1, 0L, "0"),
    NO_RANK2(2, 0L, "0"),
    FIFTH(3, 5_000L, "5,000"),
    FOURTH(4, 50_000L, "50,000"),
    THIRD(5, 1_500_000L, "1,500,000"),
    SECOND(5, 30_000_000L, "30,000,000"),
    FIRST(6, 2_000_000_000L, "2,000,000,000");


    private int count;
    private long prize;
    private String prizeString;

    Rank(int count, long prize, String prizeString) {
        this.count = count;
        this.prize = prize;
        this.prizeString = prizeString;
    }

    public int getCount() {
        return count;
    }

    public long getPrize() {
        return prize;
    }

    public String getprizeString() {
        return prizeString;
    }
}
