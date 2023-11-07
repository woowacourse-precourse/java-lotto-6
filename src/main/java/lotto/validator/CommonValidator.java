package lotto.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constant.ErrorMessage.ENTER_PROPER_INTEGER;
import static lotto.constant.ErrorMessage.ENTER_PROPER_NATURAL_NUMBER;


public class CommonValidator {
    private CommonValidator() {
    }

    public static void validateIsNaturalNumber(String input) {
        validateIsInteger(input);

        int number = Integer.parseInt(input);
        if(number <= 0) {
            throw new IllegalArgumentException(ENTER_PROPER_NATURAL_NUMBER);
        }
    }

    public static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ENTER_PROPER_INTEGER);
        }
    }


}
