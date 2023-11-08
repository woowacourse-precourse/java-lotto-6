package lotto.global.utils;

import static lotto.global.constant.ErrorMessage.AMOUNT_FORMAT_ERROR_MESSAGE;
import static lotto.global.constant.ErrorMessage.AMOUNT_MULTIPLE_ERROR_MESSAGE;
import static lotto.global.constant.Game.LOTTO_PRICE;

public class Validator {

    private static final String ZERO = "0";
    private static final String AMOUNT_PATTERN = "^(0|[1-9]+[0-9]*)$";

    public static boolean validatePurchaseAmount(String input) {
        validateFormat(input);
        validateMultipleOfPrice(input);
        return true;
    }

    private static boolean validateFormat(String input) {
        if (!input.matches(AMOUNT_PATTERN) || input.equals(ZERO) || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(AMOUNT_FORMAT_ERROR_MESSAGE);
        }
        return true;
    }

    private static boolean validateMultipleOfPrice(String input) {
        Long amount = Long.parseLong(input);
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_MULTIPLE_ERROR_MESSAGE);
        }
        return true;
    }


}
