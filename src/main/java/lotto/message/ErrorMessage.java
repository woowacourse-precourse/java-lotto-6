package lotto.message;

public class ErrorMessage {
    public static final String NO_INPUT_ERROR = "[ERROR] 정확한 값을 입력하세요.";
    public static final String INVALID_AMOUNT_FORMAT_ERROR = "[ERROR] 구입 금액은 로또 가격 단위로 이루어져야 합니다.";
    public static final String INVALID_COUNT_OF_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호의 개수는 정확히 6개이어야 합니다.";
    public static final String INVALID_FORMAT_ERROR = "[ERROR] 잘못된 형식의 입력입니다.";
    public static final String NUMBER_OUT_OF_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBERS_ERROR = "[ERROR] 당첨 번호 내에 중복된 숫자가 존재합니다.";
    public static final String DUPLICATE_NUMBER_IN_BONUS_ERROR = "[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.";
    public static final String WRONG_RANK_STATE = "[ERROR] 잘못된 등수 상태입니다.";

    private ErrorMessage() {
    }

}
