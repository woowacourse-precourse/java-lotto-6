package lotto.view;

public class ErrorMessage {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private static final String ERROR_MESSAGE_RANGE = "입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다.\n";
    private static final String ERROR_MESSAGE_DUPLICATE = "입력 값들은 서로 중복되지 않아야 합니다.\n";
    private static final String ERROR_MESSAGE_QUANTITY = "입력 값의 개수는 %d개 여야 합니다.\n";
    private static final String ERROR_MESSAGE_MULTIPLE = "입력 값은 %d의 배수여야 합니다.\n";
    private static final String ERROR_MESSAGE_LIMIT = "입력 값은 %d 이하의 값이어야 합니다.\n";
    private static final String ERROR_MESSAGE_IS_INTEGER = "입력 값은 숫자로만 이루어져 있어야 합니다.\n";
    private static final String ERROR_MESSAGE_IS_DUPLICATE = "입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다.\n";

    public static void numberInRangeError(int startInclusive, int encInclusive) {
        System.out.printf(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_RANGE, startInclusive, encInclusive);
    }

    public static void duplicationListError() {
        System.out.printf(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_DUPLICATE);
    }

    public static void lengthError(int length) {
        System.out.printf(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_QUANTITY, length);
    }

    public static void multipleNumberError(int divisor) {
        System.out.printf(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_MULTIPLE, divisor);
    }

    public static void exceedError(int limitNumber) {
        System.out.printf(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_LIMIT, limitNumber);
    }

    public static void stringToIntegerError() {
        System.out.printf(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_IS_INTEGER);
    }

    public static void duplicatedNumberInListError() {
        System.out.printf(ERROR_MESSAGE_PREFIX + ERROR_MESSAGE_IS_DUPLICATE);
    }
}
