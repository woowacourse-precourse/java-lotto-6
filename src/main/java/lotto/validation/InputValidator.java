package lotto.validation;

import java.util.Arrays;
import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;
import lotto.enums.RegexPattern;
import lotto.util.Convertor;

public class InputValidator {

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
        if (RegexPattern.NOT_NUMBER.matches(input)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }

    private static void validateIsNumberSeparatedByComma(String input) {
        String[] numbers = Convertor.splitByComma(input);
        boolean hasNonNumber = Arrays.stream(numbers)
                .anyMatch(number -> RegexPattern.NOT_NUMBER.matches(input));
        if (hasNonNumber) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER.getMessage());
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(Delimiter.COMMA.getDelimiter())) {
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
