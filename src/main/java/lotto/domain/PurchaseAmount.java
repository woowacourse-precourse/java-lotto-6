package lotto.domain;

public class PurchaseAmount {

    private static final int NO_PURCHASE_AMOUNT = 0;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int NONE = 0;
    private final Integer value;

    public PurchaseAmount(final Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(final Integer value) {
        if (value <= NO_PURCHASE_AMOUNT || value % PURCHASE_AMOUNT_UNIT != NONE) {
            throw new IllegalArgumentException();
        }
    }
}
