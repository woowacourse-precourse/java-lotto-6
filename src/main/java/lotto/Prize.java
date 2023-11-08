package lotto;

public enum Prize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);
    private final int prizeMoney;

    Prize(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney(int rank) {
        if (rank == 1) {
            return FIRST.prizeMoney;
        }
        if (rank == 2) {
            return SECOND.prizeMoney;
        }
        if (rank == 3) {
            return THIRD.prizeMoney;
        }
        if (rank == 4) {
            return FOURTH.prizeMoney;
        }
        if (rank == 5) {
            return FIFTH.prizeMoney;
        }
        return prizeMoney;
    }
}