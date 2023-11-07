package lotto.constant;

public enum PurchaseAmount {
    UNIT(1000),
    MIN(1000),
    MAX(100000);

    private final long amount;

    PurchaseAmount(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return this.amount;
    }
}
