package lotto.Constant;

public enum PurchaseAmount {
    UNIT(1000),
    MIN(1000),
    MAX(100000);

    private final int amount;

    PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
