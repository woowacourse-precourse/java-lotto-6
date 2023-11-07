package constant;

public enum WinningPrize {
    RANK_1ST(2000000000),
    RANK_2ND(30000000),
    RANK_3RD(1500000),
    RANK_4TH(50000),
    RANK_5TH(5000),
    ;

    private final int rank;

    WinningPrize(int rank) {
        this.rank = rank;
    }

    public int get() {
        return rank;
    }
}
