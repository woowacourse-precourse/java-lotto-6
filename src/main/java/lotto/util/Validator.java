package lotto.util;

public class Validator {
    private static final String INVALID_MONEY_TYPE = "[ERROR] 금액은 숫자여야 합니다.";

    public static void validateMoney(String money) {
        validateMoneyType(money);
    }

    public static void validateMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY_TYPE);
        }
    }
}
