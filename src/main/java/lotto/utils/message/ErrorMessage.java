package lotto.utils.message;

public class ErrorMessage {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String INVALID_NUMBER = ERROR_MESSAGE + "숫자를 입력해야 합니다.";
    public static final String INDIVISIBLE_AMOUNT = ERROR_MESSAGE + "구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String INVALID_AMOUNT_RANGE = ERROR_MESSAGE + "최소 1,000원 이상의 구입 금액을 입력해야 합니다.";
    public static final String INVALID_NUMBER_SIZE = ERROR_MESSAGE + "번호의 개수가 6개가 아닙니다.";
    public static final String DUPLICATED_NUMBER = ERROR_MESSAGE + "번호에 중복된 숫자가 존재합니다.";
    public static final String INVALID_NUMBER_RANGE = ERROR_MESSAGE + "번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_SPLIT_DELIMITER = ERROR_MESSAGE + "쉼표(,)를 기준으로 구분해야 합니다.";
    public static final String DUPLICATED_BONUS_NUMBER = ERROR_MESSAGE + "당첨 번호에 보너스 번호와 중복되는 숫자가 존재합니다.";
}
