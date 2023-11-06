package lotto.model;

import static lotto.views.MessageManager.*;

public class InputValidator {
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
}
