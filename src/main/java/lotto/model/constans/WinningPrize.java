package lotto.model.constans;

public enum WinningPrize {
    FIRST_PRIZE(1, 6, 2_000_000_000),
    SECOND_PRIZE(2, 5, 30_000_000),
    THIRD_PRIZE(3, 5, 1_500_000),
    FORTH_PRIZE(4, 4, 50_000),
    FIFTH_PRIZE(5, 3, 5_000),
    NO_PRIZE(0, 0, 0);


    private final int rank;
    private final int matchingNumbersCount;
    private final long prize;

    WinningPrize(int rank, int matchingNumbersCount, long prize) {
        this.rank = rank;
        this.matchingNumbersCount = matchingNumbersCount;
        this.prize = prize;
    }

    public static int getRankByResult(int matchingNumbersCount, boolean matchBonusNumber) {
        if (matchingNumbersCount == 5) {
            if (matchBonusNumber) {
                return SECOND_PRIZE.rank;
            }
            return THIRD_PRIZE.rank;
        }
        for (WinningPrize prize : values()) {
            if (prize.matchingNumbersCount == matchingNumbersCount) {
                return prize.rank;
            }
        }
        return NO_PRIZE.rank;
    }

    public static long getPrizeByRank(int rank) {
        for (WinningPrize prize : values()) {
            if (prize.rank == rank) {
                return prize.prize;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 등수입니다.");
    }
}
