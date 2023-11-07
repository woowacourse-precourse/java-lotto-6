package lotto.utils;

public class Constants {
    public static final int INIT_VALUE = 0;
    public static final int INCREMENT_VALUE = 1;
    public static final int PERCENT_VALUE = 100;
    public static final int ZERO_MONEY = 0;
    public static final int DIVIDE_UNIT = 1000;
    public static final int MOD = 0;
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_GENERATE_VALUE = 1;
    public static final int MAX_GENERATE_VALUE = 45;
    public static final int LESS_CORRECT_THREE = 2;
    public static final int CORRECT_THREE = 3;
    public static final int CORRECT_FOUR = 4;
    public static final int CORRECT_FIVE = 5;
    public static final int CORRECT_SIX = 6;
    public static final int PRIZE_NONE_MONEY = 0;
    public static final int PRIZE_FIFTH_MONEY = 5_000;
    public static final int PRIZE_FOURTH_MONEY = 50_000;
    public static final int PRIZE_THIRD_MONEY = 1_500_000;
    public static final int PRIZE_SECOND_MONEY = 30_000_000;
    public static final int PRIZE_FIRST_MONEY = 2_000_000_000;

    public static final String NUMBER_INPUT_REGEX = "\\d+";
    public static final String START_BRACKET = "[";
    public static final String END_BRACKET = "]";
    public static final String ENTER_LINE = "\n";

    public static final String PRIZE_MESSAGE = "\n당첨 통계\n---\n";
    public static final String HYPHEN = " - ";
    public static final String COUNT = "개";
    public static final String REQUEST_INPUT_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String REQUEST_INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String REQUEST_INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public static final String PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    public static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String PRIZE_NONE_MESSAGE = "";
    public static final String PRIZE_FIFTH_MESSAGE = CORRECT_THREE + "개 일치 (5,000원)";
    public static final String PRIZE_FORTH_MESSAGE = CORRECT_FOUR + "개 일치 (50,000원)";
    public static final String PRIZE_THIRD_MESSAGE = CORRECT_FIVE + "개 일치 (1,500,000원)";
    public static final String PRIZE_SECOND_MESSAGE = CORRECT_FIVE + "개 일치, 보너스 볼 일치 (30,000,000원)";
    public static final String PRIZE_FIRST_MESSAGE = CORRECT_SIX + "개 일치 (2,000,000,000원)";
}