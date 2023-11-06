package lotto.validator;

import lotto.Constant;

public class MoneyValidator {
    private static final int LOTTO_PRICE = Constant.LOTTO_PRICE;
    private static final int MONEY_THRESHOLD = Constant.MONEY_THRESHOLD;

    private MoneyValidator() {
    }

    public static void validateMinimumMoney(long money) {
        final String message = "로또 구입 금액은 %s원 이상이어야 합니다.";
        if (money < MONEY_THRESHOLD) {
            throw new IllegalArgumentException(String.format(message, MONEY_THRESHOLD));
        }
    }

    public static void validateMoneyDivisible(long money) {
        final String message = "로또 구입 금액은 %d원 단위여야 합니다.";
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(message, LOTTO_PRICE));
        }
    }
}
