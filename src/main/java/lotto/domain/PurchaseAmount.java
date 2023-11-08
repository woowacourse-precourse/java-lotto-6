package lotto.domain;

import lotto.constant.ExceptionMessage;

public class PurchaseAmount {

    private static final int MIN_MONEY = 0;

    private final int money;

    public PurchaseAmount(int money) {
        validateMoneyRange(money);
        this.money = money;
    }

    public int changeBy(int amount) {
        return money/amount;
    }

    private void validateMoneyRange(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_NUMBER.getMessage());
        }
    }

    public boolean divisible(int amount) {
        if (money % amount == 0) {
            return true;
        }
        return false;
    }
}
