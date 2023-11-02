package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;
import lotto.util.Convertor;

public class InputValidator {
    private static final String ZERO = "0";
    private static final String COMMA = ",";
    private static final int STANDARD_OF_DIVIDE = 1000;
    private static final Pattern NOT_NUMBER = Pattern.compile(".*[\\D].*");
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;
    private static final int WINNING_NUMBER_SIZE = 6;


    private InputValidator() {
    }

    public static void validate(String input) {
        validateNull(input);
        validateZero(input);
        validateIsNumber(input);
        validateDivisibleByThousand(input);
        validateSeparator(input);
    }

    private static void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL.getMessage());
        }
    }

    private static void validateZero(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERO.getMessage());
        }
    }

    private static void validateIsNumber(String input) {
        if (NOT_NUMBER.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }

    private static void validateDivisibleByThousand(String input) {
        int price = Convertor.convertStringToInt(input);
        if (isNotDivisibleByThousand(price)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDE.getMessage());
        }
    }

    private static boolean isNotDivisibleByThousand(int price) {
        if ((price % STANDARD_OF_DIVIDE) != 0) {
            return true;
        }
        return false;
    }

    public static void validateSeparator(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA.getMessage());
        }
    }

    public static void validateNumberRange(String input) {
        int number = Convertor.convertStringToInt(input);
        if (number < MIN_NUMBER_RANGE || number > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }

    public static void validateNumberSize(String input) {
        String[] winningNumbers = splitByComma(input);
        if (winningNumbers.length != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }

    public static void validateDuplication(String input) {
        String[] winningNumbers = splitByComma(input);
        int deDuplicatedCount = Arrays.stream(winningNumbers)
                .collect(Collectors.toSet())
                .size();
        if (winningNumbers.length != deDuplicatedCount) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATION.getMessage());
        }
    }

    private static String[] splitByComma(String input) {
        return input.split(COMMA);
    }
}
