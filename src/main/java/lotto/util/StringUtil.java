package lotto.util;

import static lotto.error.message.InvalidInputErrorMessage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.error.exception.InvalidInputException;

public class StringUtil {
    public static Integer convertToInteger(String input) {
        if (input == null) {
            throw new IllegalStateException();
        }

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(NOT_A_NUMBER.getMessage(), input);
        }
    }

    public static List<String> tokenizeWithDelimiter(String input, String delimiter) {
        if (input == null || delimiter == null) {
            throw new IllegalStateException();
        }

        List<String> tokenizedInputs = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            tokenizedInputs.add(stringTokenizer.nextToken());
        }
        return tokenizedInputs;
    }
}
