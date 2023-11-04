package lotto.domain;

public enum LottoPrize {
    FIRST_PLACE(2000000000L),
    SECOND_PLACE(30000000L),
    THIRD_PLACE(1500000L),
    FORTH_PLACE(50000L),
    FIFTH_PLACE(5000L),
    NO_PLACE(0L);

    private final long amount;

    LottoPrize(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
