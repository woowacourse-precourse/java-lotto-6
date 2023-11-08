package lotto.constraint;

public enum PurchaseAmountConstraint {
    MINIMUM_PURCHASE_UNIT_AMOUNT(1_000),
    POSITIVE_THRESHOLD(0);

    private final int value;

    PurchaseAmountConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}