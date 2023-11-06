package lotto.module.store;

public enum LottoPrizeTable {
    FIRST_PLACE(1, 6, 2_000_000_000),
    SECOND_PLACE(2, 6, 30_000_000),
    THIRD_PLACE(3, 5, 1_500_000),
    FOURTH_PLACE(4, 4, 50_000),
    FIFTH_PLACE(5, 3, 5_000),
    ;

    private final int rank;
    private final int matchCount;
    private final int prize;

    LottoPrizeTable(int rank, int matchCount, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

}
