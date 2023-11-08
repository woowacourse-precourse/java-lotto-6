package lotto.enumeration;

public enum WinningPrize {
    FIRST(0, 2000000000, 6),
    SECOND(1, 30000000, 5),
    THIRD(2, 1500000, 5),
    FOURTH(3, 50000, 4),
    FIFTH(4, 5000, 3);

    private final int rank;
    private final int prize;
    private final int count;

    private WinningPrize(int rank, int prize, int count) {
        this.rank = rank;
        this.prize = prize;
        this.count = count;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
