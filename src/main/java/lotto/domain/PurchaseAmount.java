package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(String amount) {
        validate(amount);
        this.amount = toInt(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    private void validate(String amount) {
        if(isEmpty(amount)) {
            ErrorMessage.PURCHASE_AMOUNT_IS_EMPTY.throwIllegalArgumentException();
        }
        if(!isNumeric(amount)) {
            ErrorMessage.PURCHASE_AMOUNT_IS_NOT_A_NUMBER.throwNumberFormatException();
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
}
