package lotto.validate;

import static lotto.exception.ErrorMessage.*;
import java.util.List;

public class InputValidate {
    public static void validateEmpty(String input) {
        if (input.isBlank()) {
            System.out.println(EMPTY.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static int validateNumberFormat(String input) {
        return Integer.parseInt(input);
    }

    public static void validateStartNumber(String input) {
        final int START_NUMBER = 0;
        final char CHECK_CHARACTER = '0';
        if (input.charAt(START_NUMBER) == CHECK_CHARACTER) {
            System.out.println(START_LETTER_ZERO.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateUnit(int input) {
        final int UNIT = 1000;
        final int REST_NUMBER = 0;
        if (input % UNIT != REST_NUMBER) {
            System.out.println(INCORRECT_THOUSAND_UNIT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateWinNumberFormat(String winNumber) {
        final int START_NUMBER = 0;
        final int LAST_NUMBER = winNumber.length() - 1;
        final char CHECK_CHARACTER = ',';
        if (winNumber.charAt(START_NUMBER) == CHECK_CHARACTER || winNumber.charAt(LAST_NUMBER) == CHECK_CHARACTER) {
            System.out.println(INCORRECT_WIN_NUMBER_FORMAT.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateSixNumber(List<Integer> parseWinNumbers) {
        final int TARGET_NUMBER_COUNT = 6;
        if (parseWinNumbers.size() != TARGET_NUMBER_COUNT) {
            System.out.println(NOT_SIX_NUMBER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberRange(int parseBounusNumber) {
        final int MIN_RAGNE = 1;
        final int MAX_RANGE = 45;
        if (parseBounusNumber < MIN_RAGNE || parseBounusNumber > MAX_RANGE) {
            System.out.println(NOT_IN_INPUT_RANGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicateNumber(List<Integer> parseWinNumbers, int parseBounusNumber) {
        if (parseWinNumbers.contains(parseBounusNumber)) {
            System.out.println(DUPLICATE_NUMBER.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }
}
