package lotto;

import static lotto.ErrorMessages.INVALID_PURCHASE_AMOUNT_FORMAT;

public class Validator {
    public static int checkIsInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT);
        }
    }
}
