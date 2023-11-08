package lotto.domain;

import lotto.enums.ErrorMessages;

public class Money {
    private static final int UNIT = 1_000;
    private final int amount;

    public Money(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (isCorrectUnit(amount)) {
            System.out.println(ErrorMessages.PURCHASE_UNIT.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_UNIT.getErrorMessage());
        }
        if (isZero(amount)) {
            System.out.println(ErrorMessages.PURCHASE_LEAST.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_LEAST.getErrorMessage());
        }
    }

    private boolean isCorrectUnit(Integer amount) {
        return amount % UNIT != 0;
    }

    private boolean isZero(Integer amount) {
        return amount == 0;
    }

    public int getPurchasingQuantity() {
        return amount / UNIT;
    }
}
