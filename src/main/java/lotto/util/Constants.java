package lotto.util;

public class Constants {
    // Jackpot
    public static final String NUMBER_PATTERN = "\\d+";
    public static final int LOTTERY_NUMBER_MIN = 1;
    public static final int LOTTERY_NUMBER_MAX = 45;
    public static final String ERROR_MESSAGE_WINNING_NUMBERS_NUMERIC = "[ERROR] 당첨 번호는 숫자로만 이루어져야 합니다.";
    public static final String ERROR_MESSAGE_NOT_SIX_NUMBERS = "[ERROR] 당첨 번호는 6개로 이루어져야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_NUMBERS = "[ERROR] 당첨번호에 중복된 숫자가 들어갈 수 없습니다.";
    public static final String ERROR_MESSAGE_NOT_CONTAINS_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String ERROR_MESSAGE_NUMBER_IN_RANGE = "[ERROR] 당첨 번호/보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    public static final int WINNING_NUMBERS_SIZE = 6;

    // Purchase
    public static final String ERROR_MESSAGE_AMOUNT_NOT_IN_THOUSANDS = "[ERROR] 구매 금액은 1000원 단위여야 합니다.";
    public static final String ERROR_MESSAGE_AMOUNT_NUMERIC = "[ERROR] 구매 금액은 숫자로만 이루어져야 합니다.";

    // Result
    public static final double PROFIT_RATE_MULTIPLIER = 1000.0;
    public static final double PROFIT_RATE_PERCENTAGE = 100.0;
    public static final double PROFIT_RATE_BASE = 10.0;
    public static final int PRICE_VALUE = 1000;
    public static final int DEFAULT_COUNT = 0;
    public static final int PLUS_VALUE = 1;
    public static final int DEFAULT_VALUE = 0;

    // PrizeRank
    public static final int FIRST_PRICE = 2000000000;
    public static final int SECOND_PRICE = 30000000;
    public static final int THIRD_PRICE = 1500000;
    public static final int FOURTH_PRICE = 50000;
    public static final int FIFTH_PRICE = 5000;

}
