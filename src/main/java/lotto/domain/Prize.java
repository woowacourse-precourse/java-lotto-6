package lotto.domain;

public enum Prize {
    FIRST(1,  2_000_000_000),
    SECOND(2,30_000_000),
    THIRD(3, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(5, 5_000);

    private final int rank;
    private final int winningAmount;

    Prize(int rank, int winningAmount) {
        this.rank = rank;
        this.winningAmount = winningAmount;
    }

    public static Prize matchingCountOf(int matchingCount) {
        return switch (matchingCount) {
            case 6 -> Prize.FIRST;
            case 5 -> Prize.THIRD;
            case 4 -> Prize.FORTH;
            case 3 -> Prize.FIFTH;
            default -> throw new RuntimeException("RuntimeException");
        };
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}