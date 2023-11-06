package lotto.message;

public class MessageConstants {
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;

    public static final int ZERO = 0;
    public static final int ONE = 1;

    public static final int ONE_HUNDRED = 100;
    public static final int ONE_THOUSAND = 1000;

    public static final String MESSAGE_SECOND = "5개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String MESSAGE_THIRD = "5개 일치 (%s원) - %d개";
    public static final String MESSAGE_FOURTH = "4개 일치 (%s원) - %d개";
    public static final String MESSAGE_FIFTH = "3개 일치 (%s원) - %d개";
    public static final String MESSAGE_FIRST = "6개 일치 (%s원) - %d개";
    public static final int PRIZE_FIFTH = 5_000;
    public static final int PRIZE_FOURTH = 50_000;
    public static final int PRIZE_THIRD = 1_500_000;
    public static final int PRIZE_SECOND = 30_000_000;
    public static final int PRIZE_FIRST = 2_000_000_000;

    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static final String OUTPUT_PURCHASED_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    public static final String OUTPUT_WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---\n%s";
    public static final String OUTPUT_TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
}
