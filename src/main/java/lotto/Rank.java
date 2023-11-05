package lotto;

public enum Rank {
    THREE(3, 5000.0), FOUR(4, 50000.0), FIVE(5, 1500000.0), FIVE_BONUS(5, 30000000.0), SIX(6, 2000000000.0);

    private final int rank;
    private final double prize;

    Rank(int rank, double prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public double getPrize() {
        return prize;
    }

}
