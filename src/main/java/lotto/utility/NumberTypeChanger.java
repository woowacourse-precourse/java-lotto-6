package lotto.utility;

import lotto.message.PurchaseErrorMessage;

public class NumberTypeChanger {
    private static final String MATCH_NUMBER = "\\d+";

    public static int changeNumberType(String input) {
        validateNumber(input);
        parseIntOrThrow(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(PurchaseErrorMessage.NOT_NUMBER_ERROR.getMessage());
        }
    }

    public static void parseIntOrThrow(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PurchaseErrorMessage.OUT_RANGE_ERROR.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches(MATCH_NUMBER);
    }
}
