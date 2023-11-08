package lotto.validation;

import lotto.exception.DataTypeRangeException;
import lotto.exception.IncludeCharException;
import lotto.exception.InputBlankException;

public class Validator {
    public static void checkBlank(String readline) {
        if (readline == null || readline.isBlank()) {
            throw InputBlankException.inputBlankException;
        }
    }

    public static void checkDigit(String readLine) {
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i))) {
                throw IncludeCharException.includeCharException;
            }
        }
    }

    public static int validateParseNumber(String readLine) {
        try {
            return Integer.parseInt(readLine);
        } catch (NumberFormatException e) {
            throw DataTypeRangeException.dataTypeRangeException;
        }
    }
}
