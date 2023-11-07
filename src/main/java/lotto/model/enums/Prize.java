package lotto.model.enums;

public enum Prize {
    PRIZE1(1, 2000000000),
    PRIZE2(2, 30000000),
    PRIZE3(3, 1500000),
    PRIZE4(4, 50000),
    PRIZE5(5, 5000),
    NO_PRIZE(-1, 0);

    private final int rank;
    private final long prize;

    Prize(int rank, long prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public boolean isMatch(int rank) {
        return this.rank == rank;
    }

    public long getPrize() {
        return this.prize;
    }
}
