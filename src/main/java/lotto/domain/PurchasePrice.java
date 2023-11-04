package lotto.domain;

import lotto.util.ExceptionMessage;

public class PurchasePrice {

    public static final int MINIMUM_UNIT_PRICE = 1000;

    private final Integer amount;

    public static PurchasePrice of(Integer amount) {
        return new PurchasePrice(amount);
    }

    private PurchasePrice(Integer amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(Integer amount) {
        if (amount % MINIMUM_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_UNIT_PRICE.getMessage());
        }
    }
}
