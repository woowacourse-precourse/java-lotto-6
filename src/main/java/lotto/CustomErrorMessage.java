package lotto;

public class CustomErrorMessage {
    private static final String ERROR_PREFIX = "[ERROR]";
    public static final String PRICE_VALID = String.join(" ", ERROR_PREFIX, "금액은 양수여야 합니다.");
    public static final String NUMBER_FORMAT = String.join(" ", ERROR_PREFIX, "입력값은 숫자여야 합니다.");
    public static final String DUPLICATED_BONUS_NUMBER = String.join(" ", ERROR_PREFIX, "기존 6개 숫자와 중복됩니다.");
    public static final String WRONG_NUMBER_LENGTH = String.join(" ", ERROR_PREFIX, "기본 숫자의 개수가 잘못되었습니다.");
    public static final String DUPLICATED_NUMBERS = String.join(" ", ERROR_PREFIX, "중복된 숫자가 존재합니다.");
    public static final String CHANGE = String.join(" ", ERROR_PREFIX, "잔돈이 존재합니다.");
}
