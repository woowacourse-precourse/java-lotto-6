package lotto.model;

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
        String[] parts = input.split(COMMA_SEPARATOR);
        String result = String.join("", parts);
        Set<Character> inputNumber = new HashSet<>();
        for (int i=0;i<result.length();i++) {
            char character = input.charAt(i);
            inputNumber.add(character);
        }
        if (inputNumber.size()!=WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(getDuplicateNumberMessage());
        }
    }
}
