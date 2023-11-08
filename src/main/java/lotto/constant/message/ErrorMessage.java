package lotto.constant.message;

import static lotto.constant.SystemData.*;

public class ErrorMessage {
    private static final String PREFIX = "[ERROR] ";

    /* 공통 */
    public static final String NUMBER_FORMAT_ERROR
            = PREFIX + "숫자만 입력 가능합니다.";

    public static final String INVALID_LOTTO_NUMBER_RANGE
            = PREFIX + String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_IN_LOTTO_NUMBER, MAX_IN_LOTTO_NUMBER);


    /* 로또 구입 금액 */
    public static final String INVALID_PURCHASE_AMOUNT_UNIT
            = PREFIX + String.format("%s원 단위의 금액만 입력 가능합니다.", MONEY_FORMAT.format(PURCHASE_AMOUNT_UNIT));


    /* 당첨 번호 6자리 */
    public static final String DUPLICATE_WINNING_NUMBER
            = PREFIX + "당첨 번호는 서로 중복되지 않아야 합니다.";

    public static final String INVALID_WINNING_NUMBER_LENGTH
            = PREFIX + String.format("당첨 번호는 %d개의 숫자여야 합니다.", NUMBER_OF_WINNING_NUMBER);


    /* 보너스 번호 */
    public static final String DUPLICATE_BONUS_NUMBER
            = PREFIX + "이미 당첨번호로 설정한 번호는 보너스 번호가 될 수 없습니다.";
}
