package lotto.utils;

import lotto.constants.ErrorCode;

public class ParseUtils {

    public int parseStringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.AMOUNT_FORMAT.getMessage());
        }
    }
}
