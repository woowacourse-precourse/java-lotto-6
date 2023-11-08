package lotto.domain;

import lotto.utils.MessageConstant;

public record Money(int purchaseMoney) {
    private static final int MIN_MONEY = 0;
    private static final int CURRENCY = 1000;

    public Money {
        validate(purchaseMoney);
    }

    private void validate(int money) {
        validateOufOfRange(money);
        validateMultipleOf1000(money);
    }

    private void validateMultipleOf1000(int money) {
        if (!isMultipleOf1000(money)) {
            throw new IllegalArgumentException(MessageConstant.MONEY_OUT_OF_RANGE);
        }
    }

    private boolean isMultipleOf1000(int money) {
        return (money % CURRENCY) == 0;
    }

    private void validateOufOfRange(int money) {
        if (isOutOfRange(money)) {
            throw new IllegalArgumentException(MessageConstant.MONEY_OUT_OF_RANGE);
        }
    }

    private boolean isOutOfRange(int money) {
        return money <= MIN_MONEY;
    }

    public int getLottoCount() {
        return purchaseMoney / CURRENCY;
    }

    public int getPurchaseMoney() {
        return purchaseMoney;
    }
}
