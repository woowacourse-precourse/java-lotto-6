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
        if(isEmpty(amount)){
            ErrorMessage.PURCHASE_AMOUNT_IS_EMPTY.throwException();
        }
    }

    private int toInt(String amount) {
        return Integer.parseInt(amount);
    }

    private boolean isEmpty(String amount) {
        return amount == null || amount.isBlank();
    }
}
