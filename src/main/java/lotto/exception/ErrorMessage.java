package lotto.exception;

public class ErrorMessage {
    public static final String INVALID_AMOUNT_FORMAT_ERROR = "[ERROR] 구입 금액은 %d원 단위로 이루어져야 합니다.";
    public static final String INVALID_COUNT_OF_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호의 개수는 정확히 6개이어야 합니다.";
    public static final String INVALID_FORMAT_ERROR = "[ERROR] 잘못된 형식의 입력입니다.";
    public static final String NUMBER_OUT_OF_RANGE_ERROR = "[ERROR] 번호는 1이상 45이하의 수이어야 합니다.";
    public static final String DUPLICATE_NUMBERS_ERROR = "[ERROR] 당첨 번호 내에 중복된 숫자가 존재합니다.";
    public static final String DUPLICATE_NUMBER_IN_BONUS_ERROR = "[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.";

    private ErrorMessage() {
    }

}
