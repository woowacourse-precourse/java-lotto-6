package lotto.validator;

import java.math.BigInteger;
import lotto.exception.ErrorMessage;

public class Validator {
    private static void isNumber(String inputMessage) {
        try {
            new BigInteger(inputMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_MESSAGE.getMessage());
        }
    }
    public static void isInteger(String inputMessage, ErrorMessage errorMessage) {
        isNumber(inputMessage);
        try {
            Integer.parseInt(inputMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static boolean validateNumberRange(int value, int min, int max) {
        if (value < min || value > max) {
            return false;
        }
        return true;
    }
}
