package lotto.model;

import static lotto.views.MessageManager.*;

public class InputValidator {
    private static String COMMA_SEPARATOR = ",";

    public static void validateNonInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(getValidateNonIntegerMessage());
        }
    }

    public static void validateDivisibleByThousand(int input) {
        if ( input % 1000 != 0) {
            throw new IllegalArgumentException(getValidateDivisibleByThousandMessage());
        }
    }

    public static void validateContainsCommaSeparator(String input) {
        if (!containsCommaSeparator(input)) {
            throw new IllegalArgumentException(getCommaSeparatorMissingMessage());
        }
    }

    private static boolean containsCommaSeparator(String input) {
        return input.contains(COMMA_SEPARATOR);
    }
}
