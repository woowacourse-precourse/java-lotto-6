package lotto.model;

public enum LottoPrize {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NONE(0, 0);

    private final long prize;
    private final int rank;

    LottoPrize(int rank, long prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public long getPrize() {
        return this.prize;
    }

    public int getRank() {
        return this.rank;
    }
}
