package lotto.util;

import lotto.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final int MAX_STRING_LENGTH = 11;
    private static final String DEFAULT_SEPARATOR = ",";

    public static List<Integer> parseIntListOrThrow(String numericSequence) {
        List<String> split = Arrays.stream(numericSequence.split(DEFAULT_SEPARATOR)).toList();
        return split.stream().map(Parser::parseIntOrThrow).toList();
    }

    public static int parseIntOrThrow(String numericString) {
        validateNumericStringLength(numericString);
        long parsed = parseLongOrThrow(numericString);
        validateIntRange(parsed);
        return Integer.parseInt(numericString);
    }

    private static long parseLongOrThrow(String numericString) {
        try {
            return Long.parseLong(numericString);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_STRING.message());
        }
    }

    private static void validateNumericStringLength(String numericString) {
        if (numericString.length() > MAX_STRING_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OUT_INTEGER_RANGE.message());
        }
    }

    private static void validateIntRange(long number) {
        if (number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_INTEGER_RANGE.message());
        }
        if (number < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_INTEGER_RANGE.message());
        }
    }
}
