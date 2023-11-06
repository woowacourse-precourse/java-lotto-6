package lotto.util;

public class ExceptionHandler {
    private static final String NON_NUMERIC_CHARACTER_ERROR_MESSAGE = "[ERROR] 로또 번호에는 문자가 들어가면 안됩니다.";
    private static final String NUMBER_BELOW_1000_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원보다 낮으면 안됩니다.";
    private static final String CHANGE_AVAILABLE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000단위어야 합니다.";

    public static void throwNonNumericInputException() {
        throw new IllegalArgumentException(NON_NUMERIC_CHARACTER_ERROR_MESSAGE);
    }

    public static void throwNumberBelow1000Exception() {
        throw new IllegalArgumentException(NUMBER_BELOW_1000_ERROR_MESSAGE);
    }

    public static void throwChangeAvailableException() {
        throw new IllegalArgumentException(CHANGE_AVAILABLE_ERROR_MESSAGE);
    }
}
