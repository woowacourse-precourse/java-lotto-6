package lotto.domain.validator;

import lotto.util.ErrorMessage;

public class MoneyValidator {
    public static final int LOTTO_PRICE = 1_000;
    private static final int POSITIVE_VALUE = 0;
    private static final int MAX_MONEY = 10_0000;

    public static void verifyDivisibleBy(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_MONEY.get());
        }
    }

    public static void verifyMinAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_MONEY_AT_LEAST.get());
        }
    }

    public static void verifyMaxAmount(int money) {
        if (money > MAX_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.EXCEEDS_MAX_AMOUNT.get());
        }
    }

    public static void verifyPositiveMoney(int money) {
        if (money < POSITIVE_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT.get());
        }
    }
}
