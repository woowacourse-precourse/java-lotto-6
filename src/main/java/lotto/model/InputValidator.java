package lotto.model;

import java.util.Set;

import static lotto.model.Utilities.inputNumberSet;
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
        Set<String> inputNumber = inputNumberSet(input);
        if (inputNumber.size()!=WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(getDuplicateNumberMessage());
        }
    }

    public static void validateWinningNumberInOneToFortyFive(String input) {
        Set<String> inputNumber = inputNumberSet(input);
        for (String element : inputNumber) {
            validateNumberInOneToFortyFive (element);
        }
    }
    private static void validateNumberInOneToFortyFive (String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(getWinningNumberInOneToFortyFiveMessage());
        }
    }
    public static void validateBonusNumberInOneToFortyFive(String input) {
        String regex = "^[1-9]|[1-3][0-9]|4[0-5]$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(getBonusNumberInOneToFortyFiveMessage());
        }
    }

}
