package lotto.util;

import static lotto.error.message.InvalidInputErrorMessage.*;
import static lotto.error.message.InvalidStateErrorMessage.UNKNOWN_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.error.exception.InvalidInputException;
import lotto.error.exception.InvalidStateException;

public class StringUtil {
    public static Integer convertToInteger(String input) {
        if (input == null) {
            throw new InvalidStateException(UNKNOWN_ERROR_MESSAGE.getMessage());
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(NOT_A_NUMBER.getMessage());
        }
    }

    public static List<String> tokenizeWithDelimiter(String input, String delimiter) {
        if (input == null || delimiter == null) {
            throw new InvalidStateException(UNKNOWN_ERROR_MESSAGE.getMessage());
        }

        List<String> tokenizedInputs = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            tokenizedInputs.add(stringTokenizer.nextToken());
        }
        return tokenizedInputs;
    }
}
