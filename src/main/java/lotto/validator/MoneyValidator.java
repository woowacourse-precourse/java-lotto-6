package lotto.validator;

public class MoneyValidator {
    private static final String REGEX_NUMBER = "^[0-9]+$";
    private static final int UNIT_AMOUNT = 1000;
    private static final int ZERO = 0;

    public static void validate(String money) {
        if (!isNumberFormat(money)) {
            throw new IllegalArgumentException();
        }

        if (!isMoneyValid(Integer.parseInt(money))) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumberFormat(String money) {
        return money.matches(REGEX_NUMBER);
    }

    private static boolean isMoneyValid(int money) {
        return money % UNIT_AMOUNT == ZERO;
    }
}
