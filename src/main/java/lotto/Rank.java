package lotto;

enum Rank {
    FIRST(2000000000, 1),
    SECOND(30000000, 2),
    THIRD(1500000, 3),
    FOURTH(50000, 4),
    FIFTH(5000, 5),
    NONE(0, 0);

    private final int prize;
    private final int rank;

    Rank(int prize, int rank) {
        this.prize = prize;
        this.rank = rank;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

}





