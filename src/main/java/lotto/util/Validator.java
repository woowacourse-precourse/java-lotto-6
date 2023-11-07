package lotto.util;

public class Validator {
    private static final String ERROR_MESSAGE_ABOUT_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";

    public static void validatePurchaseAmount(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_PURCHASE_AMOUNT);
        }
    }
}
