package lotto.validator;

import java.math.BigInteger;
import lotto.exception.ErrorMessage;

public class Validator {
    private static boolean isNumber(String inputMessage) {
        try {
            new BigInteger(inputMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_MESSAGE.getMessage());
        }
        return true;
    }
    public static boolean isInteger(String inputMessage) {
        isNumber(inputMessage);
        try {
            Integer.parseInt(inputMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_OUT_OF_RANGE_MESSAGE.getMessage());
        }
        return true;
    }

    public static boolean validateNumberRange(int value, int min, int max) {
        if (value < min || value > max) {
            return false;
        }
        return true;
    }
}
