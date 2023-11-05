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
}
