package lotto.model;

public class Constants {

    public static final String LINE_SEPARATOR = "\n";
    public static final String LOTTO_BUY_MESSAGE = "개를 구매했습니다.";
    public static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    public static final String COUNT_UNIT = "개";
    public static final String PROFIT_PREFIX = "총 수익률은 ";
    public static final String PROFIT_SUFFIX = "%입니다.";
    public static final String ERROR = "[ERROR] ";
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    public static final String SEPARATOR = ",";
    public static final String NOT_NUMBER = "숫자가 아닙니다.";
    public static final String OUT_OF_RANGE = "수의 범위 1 ~ 45를 벗어났습니다.";
    public static final String NOT_DIVISIBLE_BY_THOUSAND = "1,000으로 나누어 떨어지지 않습니다.";
    public static final String LESS_THAN_THOUSAND = "1,000보다 작습니다.";
    public static final String DUPLICATE_WINNING_NUMBERS = "당첨 번호에 중복된 번호가 존재합니다.";
    public static final String NOT_SIX_WINNING_NUMBERS = "당첨 번호가 6개가 아닙니다.";
    public static final String ALREADY_USED_WINNING_NUMBER = "이미 당첨 번호로 사용 중인 번호 입니다.";

    public static final int ZERO = 0;
    public static final int THOUSAND = 1000;
    public static final int LOTTO_PRICE = 1000;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int INITIAL_MONEY_SUM = 0;
    public static final int INITIAL_COUNT = 0;
    public static final int NUMBER_MATCH_SIX = 6;
    public static final int NUMBER_MATCH_FIVE = 5;
    public static final int NUMBER_MATCH_FOUR = 4;
    public static final int NUMBER_MATCH_THREE = 3;
    public static final int INCREMENT_VALUE = 1;
    public static final int PERCENTAGE_FACTOR = 100;
    public static final int ROUNDING_FACTOR = 10;
    public static final double DECIMAL_PLACE = 10.0;

    public static final String[] PRIZE_MESSAGES = {
        LottoPrize.NOTHING.getPrizeMessage(), LottoPrize.FIRST.getPrizeMessage(), LottoPrize.SECOND.getPrizeMessage()
        , LottoPrize.THIRD.getPrizeMessage(), LottoPrize.FOURTH.getPrizeMessage(), LottoPrize.FIFTH.getPrizeMessage()
    };

    public static final int[] PRIZE_MONEY = {
        LottoPrize.NOTHING.getPrizeMoney(), LottoPrize.FIRST.getPrizeMoney(), LottoPrize.SECOND.getPrizeMoney(),
        LottoPrize.THIRD.getPrizeMoney(), LottoPrize.FOURTH.getPrizeMoney(), LottoPrize.FIFTH.getPrizeMoney()
    };

}

