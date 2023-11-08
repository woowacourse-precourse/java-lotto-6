package lotto.constants;

public final class Constants {
    private Constants() {};

    //control#Input
    public static final String NUM_OF_TICKET_MSG = "개를 구매했습니다.";
    public static final String PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUM_MSG = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM_MSG = "보너스 번호를 입력해 주세요.";

    //control#Output
    public static final String WINNING_STATISTICS_MSG = "당첨 통계";
    public static final String THREE_BAR_MSG = "---";
    public static final String THREE_MATCH_MSG = "3개 일치 (5,000원) - ";
    public static final String FOUR_MATCH_MSG = "4개 일치 (50,000원) - ";
    public static final String FIVE_MATCH_MSG = "5개 일치 (1,500,000원) - ";
    public static final String FIVE_MATCH_BONUS_MSG = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String SIX_MATCH_MSG = "6개 일치 (2,000,000,000원) - ";
    public static final String EA_MSG = "개";
    public static final String PROFIT_MSG_1 = "총 수익률은 ";
    public static final String PROFIT_MSG_2 = "%입니다.";

    //validator#BonusNumberValidator
    public static final String BONUS_NOT_NUMBER_MSG = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_NOT_VALID_RANGE_MSG = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    //validator#PurcahseAmountValidator
    public static final String PURCHASE_NOT_NUMBER_MSG = "[ERROR] 구입금액은 숫자여야 합니다.";
    public static final String PURCHASE_NOT_POSITIVE_MSG = "[ERROR] 구입금액은 0이상의 숫자여야 합니다.";
    public static final String PURCHASE_NOT_THOUSANDS_MSG = "[ERROR] 구입금액은 1000의 배수여야 합니다.";

    //validator#WinningNumberValidator
    public static final String WINNING_NOT_VALID_FORMAT_MSG = "[ERROR] 당첨 번호는 \"(숫자),(숫자),(숫자),(숫자),(숫자),(숫자)\" 꼴의 입력이어야 합니다.";
    public static final String WINNING_NOT_NUMBER_MSG = "[ERROR] 당첨 번호 중 숫자가 아닌 입력이 있습니다.";
    public static final String WINNING_NOT_VALID_RANGE_MSG = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String WINNING_HAS_DUPLICATE_MSG = "[ERROR] 당첨 번호는 중복이 없어야 합니다.";

}