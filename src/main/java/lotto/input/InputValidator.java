package lotto.input;

import lotto.constant.Error;

public class InputValidator {
    public static void checkPurchaseAmount(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(Error.NOT_NUMBER);
        }

        if (Integer.parseInt(input) < 1000 || Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(Error.DO_NOT_DIVIDED_BY_1000);
        }
    }
}
