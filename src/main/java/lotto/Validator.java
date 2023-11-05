package lotto;

import static lotto.constants.Error.NOT_NUMBER_ERROR;
import static lotto.constants.Error.NOT_POSITIVE_NUMBER_ERROR;
import static lotto.constants.Error.RANGE_ERROR;
import static lotto.constants.Error.REMAINDER_ERROR;
import static lotto.constants.Error.ZERO_INCLUSION_ERROR;

public class Validator {

    public static void checkNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkThousands(Integer userInput) {
        if ((userInput % 1000) != 0) {
            throw new IllegalArgumentException(REMAINDER_ERROR.getMessage());
        }
    }

    public static void checkZero(String userInput) {
        if (userInput.charAt(0) == '0') {
            throw new IllegalArgumentException(ZERO_INCLUSION_ERROR.getMessage());
        }
    }

    public static void checkPositiveNumber(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkRange(Integer userInput) {
        if ((userInput < 1) || (userInput > 45)) {
            throw new IllegalArgumentException(RANGE_ERROR.getMessage());
        }
    }
}
