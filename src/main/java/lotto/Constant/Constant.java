package lotto.Constant;

public class Constant {

    public static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String INPUT_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static final String OUTPUT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String OUTPUT_LOTTO_RESULT_INTRO_MESSAGE = "당첨 통계";
    public static final String OUTOUT_COUNT_MESSAGE = "개";
    public static final String OUTPUT_RESULT_MESSAGE = "총 수익률은 ";
    public static final String OUTPUT_RESULT_END_MESSAGE = "%입니다.";

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NUMBER_PREFIX = "구입금액은 ";
    public static final String BONUS_PREFIX = "보너스 번호는 ";
    public static final String USER_NUMBER_PREFIX = "당첨 번호는 ";
    public static final String ERROR_NOT_NUMBER_MESSAGE = "숫자여야 합니다.";
    public static final String ERROR_NOT_DIVIDE_MESSAGE = "1,000원으로 나누어 떨어져야 합니다.";
    public static final String ERROR_NOT_BIGGER_MESSAGE = "1,000원 이상이어야 합니다.";
    public static final String ERROR_EMPTY_MESSAGE = "빈칸일 수 없습니다.";
    public static final String ERROR_NOT_BOUNDARY_MESSAGE = "1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_NOT_COUNT_MESSAGE = "6개의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_MESSAGE = "중복되지 않는 숫자여야 합니다.";

    public static final String NUMBER_PATTERN = "[0-9]+";
    public static final String NUMBER_DELIMITER = ",";
    public static final String DIVIDE_LINE = "---";
    public static final String RATE_STRING_FORMAT = "%,.1f";

    public static final String RANK_FIFTH = "3개 일치 (5,000원) - ";
    public static final String RANK_FOURTH = "4개 일치 (50,000원) - ";
    public static final String RANK_THIRD = "5개 일치 (1,500,000원) - ";
    public static final String RANK_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String RANK_FIRST = "6개 일치 (2,000,000,000원) - ";
    public static final String RANK_NONE = "꽝";

    public static final int LOTTO_DIVIDE_PRICE = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;
    public static final int LOTTO_MIN_MATCH_COUNT = 5;
}
