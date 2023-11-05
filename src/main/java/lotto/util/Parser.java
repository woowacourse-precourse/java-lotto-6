package lotto.util;

public class Parser {
    private static final String NUMERIC_STRING_ERROR = "[ERROR] 정수형태의 입력이 아닙니다.";
    private static final String OUT_RANGE_ERROR = "[ERROR] Integer 범위를 벗어난 입력입니다.";
    private static final int MAX_STRING_LENGTH = 11;

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
            throw new IllegalArgumentException(NUMERIC_STRING_ERROR);
        }
    }

    private static void validateNumericStringLength(String numericString) {
        if (numericString.length() > MAX_STRING_LENGTH) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR);
        }
    }

    private static void validateIntRange(long number) {
        if (number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR);
        }
        if (number < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR);
        }
    }
}
