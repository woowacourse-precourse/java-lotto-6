package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {
    private static final int AMOUNT_UNIT = 1000;
    private static final int ZERO = 0;

    private final int amount;

    public PurchaseAmount(String amount) {
        validate(amount);
        this.amount = toInt(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    private void validate(String amount) {
        if (isEmpty(amount)) {
            ErrorMessage.PURCHASE_AMOUNT_IS_EMPTY.throwIllegalArgumentException();
        }
        if (!isNumeric(amount)) {
            ErrorMessage.PURCHASE_AMOUNT_IS_NOT_A_NUMBER.throwNumberFormatException();
        }
        if (!canDivideByThousand(amount)) {
            ErrorMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.throwIllegalArgumentException();
        }
        if (isZero(amount)) {
            ErrorMessage.PURCHASE_AMOUNT_IS_ZERO.throwIllegalArgumentException();
        }
    }

    private int toInt(String amount) {
        return Integer.parseInt(amount);
    }

    private boolean isEmpty(String amount) {
        return amount == null || amount.isBlank();
    }

    private boolean isNumeric(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private boolean canDivideByThousand(String amount) {
        return toInt(amount) % AMOUNT_UNIT == ZERO;
    }

    private boolean isZero(String amount) {
        return toInt(amount) == ZERO;
    }
}
