package lotto;

import lotto.message.ErrorMessage;

public class Validator {
    public static void validateIsInt(String input) {
        if (input == null && !input.matches("\\d*")) {
            throw new IllegalArgumentException(ErrorMessage.NON_INTEGER_INPUT.getMessage());
        }
    }

    public static void validatePaymentAmount(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNAFFORDABLE_PRICE.getMessage());
        }
    }
}
