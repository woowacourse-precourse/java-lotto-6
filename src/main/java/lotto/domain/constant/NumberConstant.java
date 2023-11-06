package lotto.domain.constant;

public class NumberConstant {
    // LOTTO
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;
    public static final int LOTTO_PRICE = 1000;


    // PRIZE MONEY
    public static final long NONE_PRIZE_MONEY = 0;
    public static final long THREE_PRIZE_MONEY = 5_000;
    public static final long FOUR_PRIZE_MONEY = 50_000;
    public static final long FIVE_PRIZE_MONEY = 1_500_000;
    public static final long BONUS_PRIZE_MONEY = 30_000_000;
    public static final long SIX_PRIZE_MONEY = 2_000_000_000;


    // MatchResult
    public static final int MIN_WIN_COUNT = 3;
    public static final int SIX_WIN_COUNT = 6;
    public static final int COUNT_IDX_OFFSET = 2;
    public static final int SIX_IDX_OFFSET = 1;
    public static final int BONUS_MATCH_COUNT = 5;

    // COMPUTE SERVICE
    public static final int MATCHRESULT_INIT_NUM = 0;
    public static final int MATCHRESULT_INCREMENT = 1;
    public static final double PERCENT_MULTIPLIER = 100;
    public static final double DECIMAL_POINT_MULTIPLIER = 100;
    public static final double DECIMAL_POINT_DENOMINATOR = 100.0;


    // TEST CASE
    public static final int TEST_TICKET_NUM = 5;
}
