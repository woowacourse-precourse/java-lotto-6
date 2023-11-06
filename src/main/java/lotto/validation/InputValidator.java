package lotto.validation;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.enums.ErrorMessage;
import lotto.util.Convertor;

public class InputValidator {
    private static final String COMMA = ",";
    private static final Pattern NOT_NUMBER = Pattern.compile(".*[\\D].*");

    private InputValidator() {
    }

    public static void validatePurchasePrice(String input) {
        validateNull(input);
        validateIsNumber(input);
    }

    public static void validateWinningNumber(String input) {
        validateNull(input);
        validateIsNumberSeparatedByComma(input);
        validateSeparator(input);
        validateContainsBlank(input);
    }

    public static void validateBonusNumber(String input) {
        validateNull(input);
        validateIsNumber(input);
    }

    private static void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL.getMessage());
        }
    }

    private static void validateIsNumber(String input) {
        if (NOT_NUMBER.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }

    private static void validateIsNumberSeparatedByComma(String input) {
        String[] numbers = Convertor.splitByComma(input);
        boolean hasNonNumber = Arrays.stream(numbers)
                .anyMatch(number -> NOT_NUMBER.matcher(number).matches());
        if (hasNonNumber) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA.getMessage());
        }
    }

    private static void validateContainsBlank(String input) {
        String[] numbers = Convertor.splitByComma(input);
        if (isContainsBlank(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONTAINS_BLANK.getMessage());
        }
    }

    private static boolean isContainsBlank(String[] numbers) {
        return Arrays.stream(numbers).anyMatch(String::isBlank);
    }
}
