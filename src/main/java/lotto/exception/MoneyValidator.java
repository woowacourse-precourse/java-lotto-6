package lotto.exception;

public class MoneyValidator {

    private final static String ERROR_INVALID_AMOUNT_MSG = "[ERROR] 구입 금액은 1000원 이상이어야 하며, 1000원 단위로 나누어 떨어져야한다.";
    private final static long MIN_PURCHASE_UNIT = 1000L;

    public static void validatePurchaseAmount(long money) throws IllegalArgumentException {
        if (isLessThanMinimum(money) || isNotMultipleOfUnit(money)) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT_MSG);
        }
    }

    private static boolean isLessThanMinimum(long money) {
        return money < MIN_PURCHASE_UNIT;
    }

    private static boolean isNotMultipleOfUnit(long money) {
        return money % MIN_PURCHASE_UNIT > 0;
    }
}
