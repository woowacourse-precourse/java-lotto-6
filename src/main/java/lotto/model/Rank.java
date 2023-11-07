package lotto.model;

public class Rank {
    private static int rank;
    private static int prize;

    public Rank(int rank) {
        this.rank = rank;
        setPrize();
    }

    private static void setPrize() {
        if (rank == 1) {
            prize = 2000000;
        }
        if (rank == 2) {
            prize = 30000;
        }
        if (rank == 3) {
            prize = 1500;
        }
        if (rank == 4) {
            prize = 50;
        }
        if (rank == 5) {
            prize = 5;
        }
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}
