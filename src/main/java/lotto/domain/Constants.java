package lotto.domain;

public class Constants {
    /** 로또에 사용되는 문구 */
    public static final String GET_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String GET_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String PRINT_LOTTO_LIST = "%d개를 구입했습니다.";

    /** 로또에 사용되는 숫자 */
    public static final Integer PRICE_UNIT = 1000;
    public static final Integer MIN_LOTTO_NUM = 1;
    public static final Integer MAX_LOTTO_NUM = 45;
    public static final Integer LOTTO_LENGTH = 6;

    /** 에러 메시지 */
    public static final String NOT_INT_PRICE_ERROR = "[ERROR] 금액은 숫자로 입력해야 합니다.";
    public static final String NOT_UNIT_PRICE_ERROR = "[ERROR] 금액은 1000원 단위로 입력해야 합니다.";
    public static final String LOTTO_LENGTH_ERROR = "[ERROR] 당첨 번호의 길이는 6자리여야 합니다.";
    public static final String NOT_INT_NUMBER_ERROR = "[ERROR] 번호는 숫자로 입력해야 합니다.";
    public static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.";
}
