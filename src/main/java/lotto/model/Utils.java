package lotto.model;

public final class Utils {

    private static final String INVALID_PURCHASE_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.";

    private Utils() {
    }

    public static int convertStringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(INVALID_PURCHASE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }
}
