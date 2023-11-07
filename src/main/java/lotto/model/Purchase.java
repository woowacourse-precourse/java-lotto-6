package lotto.model;

import lotto.constants.ErrorMessage;

public class Purchase {
    private final int money;

    public Purchase(int money) {
        validateZerOrNegative(money);
        validateAmountNotDivisible(money);
        this.money = money;
    }

    private static void validateZerOrNegative(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_OR_NEGATIVE_PURCHASE.getMessage());
        }
    }

    private static void validateAmountNotDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }
    
    public int getPurchase() {
        return money;
    }
}
