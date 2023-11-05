package lotto.domain;

public class Rank {

    private int rank1;
    private int rank2;
    private int rank3;
    private int rank4;
    private int rank5;

    public Rank() {
        this.rank1 = 0;
        this.rank2 = 0;
        this.rank3 = 0;
        this.rank4 = 0;
        this.rank5 = 0;
    }

    public void addRank(int rank) {
        if (rank == 1) {
            rank1++;
            return;
        }
        if (rank == 2) {
            rank2++;
            return;
        }
        if (rank == 3) {
            rank3++;
            return;
        }
        if (rank == 4) {
            rank4++;
            return;
        }
        if (rank == 5) {
            rank5++;
        }
    }

    public int getRank(int rank) throws IllegalArgumentException {
        if (rank == 1) {
            return rank1;
        }
        if (rank == 2) {
            return rank2;
        }
        if (rank == 3) {
            return rank3;
        }
        if (rank == 4) {
            return rank4;
        }
        if (rank == 5) {
            return rank5;
        }
        throw new IllegalArgumentException();
    }
}
