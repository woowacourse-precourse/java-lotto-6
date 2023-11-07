package lotto.util;

import java.util.List;

public class Validator {
    private static final int NATURAL_NUMBER_START = 1;
    private static final String COMMA = ",";

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
        if (money % Constants.LOTTO_MIN_AMOUNT != Constants.ZERO) {
            ErrorMessage.printNotDivisionErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumberInLotto(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            ErrorMessage.printBonusIncludedErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputWithSeparator(String input) {
        if (!input.contains(COMMA)) {
            ErrorMessage.printDelimiterIsNotCommaErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
