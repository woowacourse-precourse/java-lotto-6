package lotto.validation;

import lotto.enums.ErrorMessage;
import lotto.util.Convertor;

public class InputValidator {
    private static final String ZERO = "0";
    private static final int STANDARD_OF_DIVIDE = 1000;

    private InputValidator() {
    }

    public static void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL.getMessage());
        }
    }

    public static void validateZero(String input) {
        if (input.equals(ZERO)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERO.getMessage());
        }
    }

    public static void validateDivisibleByThousand(String input) {
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
}
