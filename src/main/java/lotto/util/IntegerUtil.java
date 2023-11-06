package lotto.util;

import static lotto.configuration.PatternConstants.THOUSAND_SEPARATOR;
import static lotto.messages.ErrorMessages.INVALID_LOTTO_NUMBER_RANGE_MESSAGE;

import java.text.DecimalFormat;
import lotto.validation.IntegerValidator;

public class IntegerUtil {

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static int trimAndParseInt(String value) {
        value = value.trim();
        IntegerValidator.validateInteger(value);

        return Integer.parseInt(value);
    }


}
