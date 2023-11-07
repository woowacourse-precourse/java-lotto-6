package lotto.util;

public enum Winning {
    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 1500000),
    FOURTH(4, 4, 50000),
    FIFTH(5, 3, 5000);

    private final int rank;
    private final int count;
    private final int prize;

    Winning(int rank, int count, int prize) {
        this.rank = rank;
        this.count = count;
        this.prize = prize;
    }

    public int rank() {
        return rank;
    }

    public int count() {
        return count;
    }

    public int prize() {
        return prize;
    }
}
