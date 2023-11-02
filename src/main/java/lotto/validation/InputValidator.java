package lotto.validation;

import java.util.regex.Pattern;
import lotto.enums.ErrorMessage;
import lotto.util.Convertor;

public class InputValidator {
    private static final String ZERO = "0";
    private static final String COMMA = ",";
    private static final int STANDARD_OF_DIVIDE = 1000;
    private static final Pattern NOT_NUMBER = Pattern.compile(".*[\\D].*");

    private InputValidator() {
    }

    public static void validatePurchasePrice(String input) {
        validateNull(input);
        validateZero(input);
        validateIsNumber(input);
        validateDivisibleByThousand(input);
    }

    public static void validateWinningNumber(String input) {
        validateNull(input);
        validateIsNumber(input);
        validateSeparator(input);
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

    private static void validateSeparator(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_COMMA.getMessage());
        }
    }
}
