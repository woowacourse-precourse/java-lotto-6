package lotto.validation;

import java.util.Arrays;
import lotto.enums.Delimiter;
import lotto.enums.RegexPattern;
import lotto.util.Convertor;

public class InputValidator {
    private static final String ERROR_PREFIX = Delimiter.ERROR_PREFIX.getDelimiter();

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
            throw new IllegalArgumentException(ERROR_PREFIX + "아무런 값을 입력하지 않았습니다.");
        }
    }

    private static void validateIsNumber(String input) {
        if (RegexPattern.NOT_NUMBER.matches(input)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateIsNumberSeparatedByComma(String input) {
        String[] numbers = Convertor.splitByComma(input);
        boolean hasNonNumber = Arrays.stream(numbers)
                .anyMatch(number -> RegexPattern.NOT_NUMBER.matches(number));
        if (hasNonNumber) {
            throw new IllegalArgumentException(ERROR_PREFIX + "숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateSeparator(String input) {
        if (!input.contains(Delimiter.COMMA.getDelimiter())) {
            throw new IllegalArgumentException(ERROR_PREFIX + "쉼표로 구분하여 입력해야 합니다.");
        }
    }

    private static void validateContainsBlank(String input) {
        String[] numbers = Convertor.splitByComma(input);
        if (isContainsBlank(numbers)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "숫자를 공백으로 입력할 수 없습니다.");
        }
    }

    private static boolean isContainsBlank(String[] numbers) {
        return Arrays.stream(numbers).anyMatch(String::isBlank);
    }
}
