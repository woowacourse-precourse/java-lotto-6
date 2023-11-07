package lotto.utils.validator;

import lotto.utils.message.PurchaseAmountExceptionMessage;

public class PurchaseAmountValidator {

    public static void validate(String input) {
        validateBlank(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.BLANK.getError());
        }
    }
}
