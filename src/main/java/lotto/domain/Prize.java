package lotto.domain;

public enum Prize {
    FIRST(1, 6,  2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FORTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000),
    NONE(6, 0, 0);

    private final int rank;
    private final int matchingCount;
    private final int winningAmount;

    Prize(int rank, int matchingCount, int winningAmount) {
        this.rank = rank;
        this.matchingCount = matchingCount;
        this.winningAmount = winningAmount;
    }

    public static Prize matchingCountOf(int matchingCount) {
        return switch (matchingCount) {
            case 6 -> Prize.FIRST;
            case 5 -> Prize.THIRD;
            case 4 -> Prize.FORTH;
            case 3 -> Prize.FIFTH;
            default -> Prize.NONE;
        };
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}