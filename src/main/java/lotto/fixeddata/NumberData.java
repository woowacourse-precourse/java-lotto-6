package lotto.fixeddata;

public class NumberData {
    public static final int MONEY_UNIT = 1_000;
    public static final long MONEY_RANGE_MIN = 1_000L;
    public static final long MONEY_RANGE_MAX = 4_611_686_000L;    //Standard for MONEY_RANGE_MAX: See README.md(기능 구현 목록. 로또 구매 기능 구현에 설명되어있음)
    public static final long MIN_WINNER_MONEY = 0L;
    public static final long MAX_WINNER_MONEY = 9_223_372_000_000_000_000L;
    public static final long MIN_WINNING_NUMBER = 0L;
    public static final long MAX_WINNING_NUMBER = 4_611_686L;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int FIRST_PRIZE_MONEY = 2_000_000_000;
    public static final int SECOND_PRIZE_MONEY = 30_000_000;
    public static final int THIRD_PRIZE_MONEY = 1_500_000;
    public static final int FOURTH_PRIZE_MONEY = 50_000;
    public static final int FIFTH_PRIZE_MONEY = 5_000;
    public static final int WINNING_MIN_COUNT = 3;
}
