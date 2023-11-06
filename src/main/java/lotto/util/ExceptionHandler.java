package lotto.util;

public class ExceptionHandler {
    private static final String NON_NUMERIC_CHARACTER_ERROR_MESSAGE = "[ERROR] 로또 번호에는 문자가 들어가면 안됩니다.";

    public static void throwNonNumericInputException() {
        throw new IllegalArgumentException(NON_NUMERIC_CHARACTER_ERROR_MESSAGE);
    }
}
