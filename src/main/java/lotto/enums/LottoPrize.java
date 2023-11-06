package lotto.enums;

public enum LottoPrize {
    FIRST_PLACE(2000000000L, 6),
    SECOND_PLACE(30000000L, 5),
    THIRD_PLACE(1500000L, 5),
    FORTH_PLACE(50000L, 4),
    FIFTH_PLACE(5000L,3),
    NO_PLACE(0L, 0);

    private final long amount;
    private final int matchCount;

    LottoPrize(long amount, int matchCount) {
        this.amount = amount;
        this.matchCount = matchCount;
    }

    public long getAmount() {
        return amount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
