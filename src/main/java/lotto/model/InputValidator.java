package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static lotto.views.MessageManager.*;

public class InputValidator {
    private static String COMMA_SEPARATOR = ",";
    private static int WINNING_NUMBER_COUNT = 6;

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

    public static void validateDuplicateNumber(String input) {
        String[] winningNumbers = input.split(COMMA_SEPARATOR);
        Set<String> inputNumber = new HashSet<>();
        Collections.addAll(inputNumber, winningNumbers);
        if (inputNumber.size()!=WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(getDuplicateNumberMessage());
        }
    }
}
