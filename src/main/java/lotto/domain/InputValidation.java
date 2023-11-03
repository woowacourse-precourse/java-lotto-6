package lotto.domain;

import lotto.constant.ErrorMessage;

public class InputValidation {
    public static int checkNumber(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER.getMessage());
        }
        return result;
    }

    public static void checkDivisible(int amount) {
        int quotient = amount / 1000;
        int remainder = amount % 1000;
        if (remainder != 0 || quotient <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLENESS.getMessage());
        }
    }
}
