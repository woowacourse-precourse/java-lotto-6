package lotto.utils;

import static lotto.exception.ErrorMessage.INVLID_PAYMENT_TYPE;

public class Parser {

    public static int parsePay(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVLID_PAYMENT_TYPE.getMessage());
        }
    }

}
