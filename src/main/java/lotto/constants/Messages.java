package lotto.constants;

public class Messages {
    public static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String PROMPT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public static final String PROMPT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.";
    public static final String LOTTO_NUMBERS_MESSAGE = "[%s]";
    public static final String WINNING_STATISTICS = "\n당첨 통계\n";
    public static final String SEPARATOR_LINE = "---";
    public static final String WINNING_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String WINNING_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %s입니다.";

    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_INVALID_NUMERIC_INPUT =
            ERROR_PREFIX + "숫자를 입력해 주세요.";
    public static final String ERROR_AMOUNT_LESS_THAN_UNIT =
            ERROR_PREFIX + "로또구매금액은 " + Values.LOTTO_PURCHASE_UNIT + "원 이상이어야 합니다.";
    public static final String ERROR_AMOUNT_MAX_RANGE =
            ERROR_PREFIX + "로또구매금액은 " + Values.LOTTO_MAX_PURCHASE_AMOUNT + "원 이하여야 합니다.";
    public static final String ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT =
            ERROR_PREFIX + "로또구매금액은 " + Values.LOTTO_PURCHASE_UNIT + "원 단위로 입력해야 합니다.";
    public static final String ERROR_DUPLICATE_BONUS_NUMBER =
            ERROR_PREFIX + "보너스 번호는 당첨번호와 중복되지 않아야 합니다.";
    public static final String ERROR_RANGE_BONUS_NUMBER =
            ERROR_PREFIX + "보너스 번호는 " + Values.LOTTO_MIN_NUMBER + "부터 " + Values.LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String ERROR_COUNT_LOTTO_NUMBER =
            ERROR_PREFIX + "로또 번호는 6개를 입력 해야합니다.";
    public static final String ERROR_DUPLICATE_LOTTO_NUMBER =
            ERROR_PREFIX + "중복된 로또 번호가 있습니다.";
    public static final String ERROR_RANGE_LOTTO_NUMBER =
            ERROR_PREFIX + "로또 번호는 " + Values.LOTTO_MIN_NUMBER + "부터 " + Values.LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다.";
}
