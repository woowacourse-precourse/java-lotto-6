package lotto.util;

import java.util.List;

public class Validator {
    private static final int NATURAL_NUMBER_START = 1;
    private static final int ZERO = 0;

    private Validator() {
    }

    public static void validateInputNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            ErrorMessage.printBlankInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsParsableToInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ErrorMessage.printNotNumericNumberErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputIsNatural(int input) {
        if (input < NATURAL_NUMBER_START) {
            ErrorMessage.printNotNaturalNumberErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputRange(int input) {
        if (input < Constants.MIN_NUMBER || input > Constants.MAX_NUMBER) {
            ErrorMessage.printOutOfRangeNumberErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateUniqueLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            ErrorMessage.printDuplicateMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_SIZE) {
            ErrorMessage.printSizeErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateNonDivisibility(int money) {
        if (money % Constants.LOTTO_MIN_AMOUNT != ZERO) {
            ErrorMessage.printNotDivisionErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
