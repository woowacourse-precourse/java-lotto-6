package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.Number;

public class InputValidation {
    public static int validateNumber(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
        }
        return result;
    }

    public static void checkDivisible(int amount) {
        if (amount % Number.PRICE.getValue() != Number.ZERO.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE.getMessage());
        }
    }

    public static void checkSufficient(int amount) {
        if (amount < Number.PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT.getMessage());
        }
    }
}
