package lotto.util;

public class InputValidator {
    private final static String PURCHASE_MONEY_NOT_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private final static String PURCHASE_MONEY_MINIMUM_LIMIT = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";
    private final static String PURCHASE_MONEY_UNIT_LIMIT = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

    public static void validatePurchaseMoney(String inputMoney) {
        int money;
        try {
            money = Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_MONEY_NOT_NUMBER);
        }

        if (money < 1000) {
            throw new IllegalArgumentException(PURCHASE_MONEY_MINIMUM_LIMIT);
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_UNIT_LIMIT);
        }
    }
}
