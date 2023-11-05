package lotto.domain;

public class Constants {

    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String QUANTITY_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATS_MESSAGE = "당첨 통계";
    public static final String THREE_HYPHEN = "---";
    public static final String WINNING_THREE_NUMBERS = "3개 일치 (5,000원) - %d개\n";
    public static final String WINNING_FOUR_NUMBERS = "4개 일치 (50,000원) - %d개\n";
    public static final String WINNING_FIVE_NUMBERS = "5개 일치 (1,500,000원) - %d개\n";
    public static final String WINNING_FIVE_ADD_BONUS_NUMBERS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    public static final String WINNING_SIX_NUMBERS = "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String PROFIT = "총 수익률은 %.1f%%입니다.";

    public static final String SIX_NUMBERS_MESSAGE = "[ERROR] 6자리 숫자를 입력해 주세요.";
    public static final String UNIQUE_SIX_NUMBERS_MESSAGE = "[ERROR] 중복되지 않는 6자리 숫자를 입력해 주세요.";
    public static final String NUMBER_RANGE_MESSAGE = "[ERROR] 각 번호는 1 이상 45 이하로 입력해 주세요.";
    public static final String ONLY_NUMBER_MESSAGE = "[ERROR] 1000원 이상 숫자만 입력해 주세요.\n";
    public static final String ABOVE_THOUSAND_MESSAGE = "[ERROR] 1000원 이상 입력해 주세요.\n";
    public static final String DIVISIBLE_BY_THOUSAND_MESSAGE = "[ERROR] 1000원 단위로 입력해 주세요.\n";
    public static final String COMMA = ",";
    public static final String NO_BLANK_MESSAGE = "[ERROR] 공백은 입력이 불가능 합니다.";
    public static final String ONLY_NUMBERS_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";
    public static final String ONLY_ONE_NUMBER_MESSAGE = "[ERROR] 0 이상 숫자 하나만 입력해 주세요.";
    public static final String BONUS_NUM_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1 이상 45 이하로 입력해 주세요.";
    public static final String BONUS_NUM_DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final CharSequence BLANK = " ";

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_NUMBERS = 6;
    public static final int PERCENTAGE = 100;
    public static final int WINNING_COUNT = 3;
    public static final int ZERO_CHANGE = 0;
}
