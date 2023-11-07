package lotto.model;

public class Rank {
    private int rank;
    private int prize;

    public Rank(int rank) {
        this.rank = rank;
        this.prize = setPrize(rank);
    }

    private static int setPrize(int rank) {
        if (rank == 1) {
            return 2000000;
        }
        if (rank == 2) {
            return 30000;
        }
        if (rank == 3) {
            return 1500;
        }
        if (rank == 4) {
            return 50;
        }
        if (rank == 5) {
            return 5;
        }
        return 0;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}
