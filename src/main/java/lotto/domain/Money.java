package lotto.domain;

import static lotto.config.SystemNumberConfig.THOUSAND;
import static lotto.message.ErrorMessage.MONEY_AMOUNT;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateMultiple(money);
    }

    private void validateMultiple(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_AMOUNT.getErrorMessage());
        }
    }

    public int calculatePurchasedLotto() {
        return money / THOUSAND.getConfig();
    }

    @Override
    public String toString() {
        return String.valueOf(calculatePurchasedLotto());
    }
}
