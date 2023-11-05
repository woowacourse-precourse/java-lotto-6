package lotto.model;

import lotto.constants.ErrorMessage;

public class Purchase {
    private final int money;

    public Purchase(int money) {
        handleInvalidAmountNotDivisible(money);
        this.money = money;
    }

    private static void handleInvalidAmountNotDivisible(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }

    public int getPurchase() {
        return money;
    }
}
