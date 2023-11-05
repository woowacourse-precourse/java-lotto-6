package lotto.domain;

public final class PurchaseAmount {

    private static final int NO_PURCHASE_AMOUNT = 0;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int NONE = 0;
    private final Integer value;

    public PurchaseAmount(final Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(final Integer value) {
        if (hasNoAmount(value) || isNotDivisibleByUnit(value)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasNoAmount(final Integer value) {
        return value <= NO_PURCHASE_AMOUNT;
    }

    private boolean isNotDivisibleByUnit(final Integer value) {
        return value % PURCHASE_AMOUNT_UNIT != NONE;
    }

    public int numOfLotto() {
        return this.value / PURCHASE_AMOUNT_UNIT;
    }
}
