package lotto.configs;

public class Constant {
    public static final int LOTTO_PRICE = 1_000;
    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_FIFTH_PRIZE = 5_000;
    public static final int LOTTO_FIFTH_COUNT = 3;
    public static final int LOTTO_FOURTH_PRIZE = 50_000;
    public static final int LOTTO_FOURTH_COUNT = 4;
    public static final int LOTTO_THIRD_PRIZE = 1_500_000;
    public static final int LOTTO_THIRD_COUNT = 5;
    public static final int LOTTO_SECOND_PRIZE = 30_000_000;
    public static final int LOTTO_SECOND_COUNT = 6;
    public static final int LOTTO_FIRST_PRIZE = 2_000_000_000;
    public static final int LOTTO_FIRST_COUNT = 6;
    public static final int LOTTO_NONE_PRIZE = 0;
    public static final int LOTTO_NONE_COUNT = 0;
    public static final String LOTTO_FORMAT = "[%d, %d, %d, %d, %d, %d]";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String BLANK = " ";
    public static final String VIEW_PURCHASE = "구입금액을 입력해 주세요.";
    public static final String ERROR_MESSAGE_INVALID_NUMBER = "정수만 입력할 수 있습니다.";
    public static final String ERROR_MESSAGE_INVALID_UNIT = "1,000원 단위로만 입력할 수 있습니다.";
    public static final String ERROR_MESSAGE_DUPLICATED_NUMBER = "중복된 숫자가 있습니다.";
    public static final String VIEW_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String VIEW_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String VIEW_RATE_OF_AMOUNT = "총 수익률은 %s%%입니다.";
    public static final String VIEW_LOTTO_COUNT = "%d개를 구매했습니다.";
    public static final String VIEW_STATISTIC =
            "당첨 통계\n"
            + "---\n"
            + "3개 일치 (5,000원) - %d개\n"
            + "4개 일치 (50,000원) - %d개\n"
            + "5개 일치 (1,500,000원) - %d개\n"
            + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
            + "6개 일치 (2,000,000,000원) - %d개";

    public static final String COMMA = ",";
    public static final String ERROR_MESSAGE_NOT_ENOUGH = "개수가 충분하지 않습니다.";
}
