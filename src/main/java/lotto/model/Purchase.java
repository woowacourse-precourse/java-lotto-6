package lotto.model;

import lotto.constants.ErrorMessage;

public class Purchase {
    private final int money;

    public Purchase(int money) {
        validAmountNotDivisible(money);
        this.money = money;
    }

    private static void validAmountNotDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }

    public int getPurchase() {
        return money;
    }
}
