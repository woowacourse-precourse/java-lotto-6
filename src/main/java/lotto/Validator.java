package lotto;

public class Validator {
    private static final String ERROR_PREFIX = "[ERROR]" + " ";
    private static final String INVALID_MONEY_TYPE = "금액은 숫자로만 입력해주세요.";
    private static final String INVALID_MONEY_UNIT = "금액은 1,000원 단위로만 입력해주세요.";
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public static int validateMoney(String number) {
        int money = isInteger(number);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + INVALID_MONEY_UNIT);
        }

        return money;
    }

    public static int isInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ERROR_PREFIX + INVALID_MONEY_TYPE);
        }
    }
}
