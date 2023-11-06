package lotto.service;

public class MoneyValidator {
    private static final int MIN_MONEY = 1000;
    private static final int MAX_MONEY = 1000000;
    private static final String ONLY_NUMBER = "^[0-9]*$";

    public static int validate(String money) {
        int value = preChange(money);
        afterChange(value);

        return value;
    }

    private static int preChange(String money) {
        // Only number
        if (!money.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(MoneyValidateStatus.PRE_MONEY_ERROR.get());
        }
        return Integer.parseInt(money);
    }

    private static void afterChange(int money) {
        minValidate(money);
        didNotUnitValidate(money);
        maxValidate(money);
    }

    private static void minValidate(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(MoneyValidateStatus.MIN_MONEY_ERROR.get());
        }
    }

    private static void didNotUnitValidate(int money) {
        if (money % MIN_MONEY != 0) {
            throw new IllegalArgumentException(MoneyValidateStatus.UNIT_MONEY_ERROR.get());
        }
    }

    private static void maxValidate(int money) {
        if (money > MAX_MONEY) {
            throw new IllegalArgumentException(MoneyValidateStatus.MAX_MONEY_ERROR.get());
        }
    }
}
