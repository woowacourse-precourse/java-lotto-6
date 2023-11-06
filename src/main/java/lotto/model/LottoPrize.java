package lotto.model;

public enum LottoPrize {

    FIRST(2_000_000_000L),
    SECOND(30_000_000L),
    THIRD(1_500_000L),
    FOURTH(50_000L),
    FIFTH(5_000L),
    NONE(0L);

    private final long amount;

    LottoPrize(final long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
