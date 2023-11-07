package lotto.util;

public class ExceptionHandler {
    private static final String NON_NUMERIC_CHARACTER_ERROR_MESSAGE = "[ERROR] 로또 번호에는 문자가 들어가면 안됩니다.";
    private static final String NUMBER_BELOW_1000_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원보다 낮으면 안됩니다.";
    private static final String CHANGE_AVAILABLE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000단위어야 합니다.";
    private static final String DUPLICATED_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호에는 중복된 값이 있으면 안됩니다.";
    private static final String WINNING_NUMBER_IS_NOT_6_LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호의 길이는 6글자여야 합니다.";
    private static final String EXTRA_WINNING_NUMBER_DUPLICATED_ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복된 값이면 안됩니다.";

    public static void throwNonNumericInputException() {
        throw new IllegalArgumentException(NON_NUMERIC_CHARACTER_ERROR_MESSAGE);
    }

    public static void throwNumberBelow1000Exception() {
        throw new IllegalArgumentException(NUMBER_BELOW_1000_ERROR_MESSAGE);
    }

    public static void throwChangeAvailableException() {
        throw new IllegalArgumentException(CHANGE_AVAILABLE_ERROR_MESSAGE);
    }

    public static void throwDuplicatedWinningNumberException() {
        throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBER_ERROR_MESSAGE);
    }

    public static void throwWinningNumberLengthException() {
        throw new IllegalArgumentException(WINNING_NUMBER_IS_NOT_6_LENGTH_ERROR_MESSAGE);
    }

    public static void throwDuplicatedExtraExtraWinningNumberException() {
        throw new IllegalArgumentException(EXTRA_WINNING_NUMBER_DUPLICATED_ERROR_MESSAGE);
    }
}
