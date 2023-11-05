package lotto.domain;

import static lotto.handler.ErrorHandler.INVALID_TYPE;

public class Money {

    private final int purchaseAmount;

    private Money(String money) {
        this.purchaseAmount = validateType(money);
    }

    public static Money create(String money) {
        return new Money(money);
    }

    private int validateType(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw INVALID_TYPE.getException();
        }
    }
}
