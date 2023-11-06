package lotto.data;

public enum Winnings {
    NOTHING(0, 0),
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000);

    private final int rank;
    private final int prize;

    Winnings(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }
}
