package lotto.message;

public final class ErrorMessage {

    private static final String PREFIX = "[ERROR] ";

    public static final String NUMBER_FORMAT_EXCEPTION = PREFIX + "유효한 숫자 형식이 아닙니다.";
    public static final String NUMBER_RANGE_EXCEPTION = PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NUMBER_COUNT_EXCEPTION = PREFIX + "로또 번호는 항상 6개이어야 합니다.";

    public static final String MONEY_LIMIT_EXCEEDED_EXCEPTION = PREFIX + "구입 금액의 범위를 벗어났습니다.";
    public static final String MONEY_MOD_NONE_ZERO_EXCEPTION = PREFIX + "구입 금액은 1000의 배수여야 합니다.";
    public static final String DUPLICATE_NUMBER_EXCEPTION = PREFIX + "중복된 숫자입니다.";

    private ErrorMessage() {
    }
}
