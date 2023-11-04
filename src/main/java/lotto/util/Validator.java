package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    public static int isValidPurchaseAmount(String input) {
        isEmpty(input);
        isNumeric(input);
        isThousandUnit(input);
        return Integer.parseInt(input);
    }

    public static void isEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE);
        }
    }

    public static void isNumeric(String input) {
        if (!Pattern.matches(Constants.NUMERIC_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMERIC);
        }
    }

    public static void isThousandUnit(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_THOUSAND_UNIT);
        }
    }

    public static void isValidCommaSeparator(String input) {
        if (!Pattern.matches(Constants.VALID_COMMA_SEPARATOR_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.SEPARATOR_CHECK);
        }
    }

    public static void isDuplicateWinNumber(String[] inputs) {
        List<String> numbers = new ArrayList<>();
        for (String input : inputs) {
            if (numbers.contains(input)) {
                throw new IllegalArgumentException(ExceptionMessage.INPUT_NON_DUPLICATE_WIN_NUMBER);
            }
            numbers.add(input);
        }
    }

    public static void isNumberInRange(String input) {
        int number = Integer.parseInt(input);
        if (!(number >= 1 && number <= 45)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_IN_RANGE);
        }
    }

    public static void isSixItems(String[] input) {
        if (input.length != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SIX_ITEMS);
        }
    }
}
