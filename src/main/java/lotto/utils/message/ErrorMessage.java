package lotto.utils.message;

public class ErrorMessage {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String INVALID_NUMBER = ERROR_MESSAGE + "숫자를 입력해야 합니다.";
    public static final String INDIVISIBLE_AMOUNT = ERROR_MESSAGE + "구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String INVALID_AMOUNT_RANGE = ERROR_MESSAGE + "최소 1,000원 이상의 구입 금액을 입력해야 합니다.";
}
