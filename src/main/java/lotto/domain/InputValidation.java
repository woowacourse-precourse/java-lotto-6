package lotto.domain;

import lotto.constant.ErrorMessage;

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
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE.getMessage());
        }
    }

    public static void checkSufficient(int amount) {
        if (amount / 1000 <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT.getMessage());
        }
    }
}
