package lotto.utils;

public class Constants {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;


    public static final String INVALID_NUMBER_RANGE_ERROR = ERROR_PREFIX + "로또 번호는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + " 범위 내에 있어야 합니다.";
    public static final String NOT_INTEGER_ERROR = ERROR_PREFIX + "정수를 입력해 주십시오.";
    public static final String NOT_POSITIVE_NUMBER_ERROR = ERROR_PREFIX + "양수를 입력해 주십시오.";

    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_STATS_MESSAGE = "당첨 통계\n---";
    public static final String EARNINGS_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";


}
