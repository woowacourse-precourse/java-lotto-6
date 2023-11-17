package lotto.util;

public class PurchaseAmountConvertor {

    private static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 금액은 숫자여야 합니다. 다시 입력하세요.";

    private PurchaseAmountConvertor() {
    }

    public static Integer convert(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }
}
