package lotto;

public enum Winnings {
    NOTHING(0, 0),
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(5, 5_000);

    private final int rank;
    private final int prize;

    Winnings(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int prize() {
        return prize;
    }

    public int rank() {
        return rank;
    }
}
