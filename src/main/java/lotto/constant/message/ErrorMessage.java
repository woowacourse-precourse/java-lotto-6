package lotto.constant.message;

public final class ErrorMessage {
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public static final String ERROR_NON_EXISTENT_VALUE = ERROR_MESSAGE_PREFIX + "값이 존재하지 않습니다.\n";
    public static final String ERROR_NOT_NUMERIC_VALUE = ERROR_MESSAGE_PREFIX + "숫자로만 이루어진 값을 입력해야 합니다.\n";
    public static final String ERROR_INDIVISIBLE_BY_1000 = ERROR_MESSAGE_PREFIX + "1,000원 단위의 금액을 입력해야 합니다.\n";
    public static final String ERROR_OUT_OF_RANGES = ERROR_MESSAGE_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.\n";
    public static final String ERROR_COUNT_OF_VALUES = ERROR_MESSAGE_PREFIX + "6개의 숫자를 입력해야합니다.\n";
    public static final String ERROR_CONTAIN_CONSECUTIVE_COMMAS = ERROR_MESSAGE_PREFIX + "쉼표(,) 전후에 숫자 값을 입력해야 합니다.\n";
    public static final String ERROR_HAS_DUPLICATE_NUMBERS = ERROR_MESSAGE_PREFIX + "중복되는 숫자가 존재합니다.\n";
    public static final String ERROR_CONTAIN_BONUS_NUMBER_IN_WINNING_NUMBER = ERROR_MESSAGE_PREFIX + "당첨 번호에 포함되지 않은 숫자를 입력해야 합니다.";
}
