package lotto.domain;

public class Constants {
    /** 로또에 사용되는 문구 */
    public static final String GET_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PRINT_LOTTO_LIST = "%d개를 구입했습니다.";

    /** 로또에 사용되는 숫자 */
    public static final Integer PRICE_UNIT = 1000;
    public static final Integer MIN_LOTTO_NUM = 1;
    public static final Integer MAX_LOTTO_NUM = 45;
    public static final Integer LOTTO_LENGTH = 6;

    /** 에러 메시지 */
    public static final String NOT_INT_PRICE_ERROR = "[ERROR] 금액은 숫자로 입력해야 합니다.";
    public static final String NOT_UNIT_PRICE_ERROR = "[ERROR] 금액은 1000원 단위로 입력해야 합니다.";
}
