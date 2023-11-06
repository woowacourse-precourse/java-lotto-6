package lotto.domain;

import lotto.utility.PurchaseErrorMessage;

public class Purchase {
    private final int amount;

    public Purchase(int amount) {
        validatePositiveInteger(amount);
        validateThousandUnit(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(PurchaseErrorMessage.NOT_POSITIVE_ERROR.getMessage());
        }
    }

    private void validateThousandUnit(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(PurchaseErrorMessage.OUT_UNIT_ERROR.getMessage());
        }
    }
}
