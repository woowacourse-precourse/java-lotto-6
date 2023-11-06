package lotto.util.enumerator;

public enum WinningAmount {
    FIRST(2000000000L),
    SECOND(30000000L),
    THIRD(1500000L),
    FOURTH(50000L),
    FIFTH(5000L),
    NONE(0L);

    private final long amount;

    WinningAmount(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }
}
