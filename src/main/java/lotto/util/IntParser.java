package lotto.util;

import static lotto.config.PurchaseErrorMessage.PURCHASE_NUMERIC_ERROR_MESSAGE;

public class IntParser {
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_NUMERIC_ERROR_MESSAGE.getMessage());
        }
    }
}
