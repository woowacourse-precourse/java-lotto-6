package lotto.util;

import java.util.regex.Pattern;

public class Constants {
    public static final String COMMA =",";
    public static final int MONEY_UNIT = 1000;

    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_NUM_LENGTH = 6;

    public static final int LOTTO_MIN_COUNT = 3;
    public static final int LOTTO_COUNT_DEFAULT = 0;
    public static final int LOTTO_COUNT_SIZE= 1;
    public static final int LOTTO_BONUS_WINNER_COUNT= 5;
    public static final int LOTTO_BONUS_WINNER_INDEX= 7;

    public static final Pattern MONEY_PATTERN = Pattern.compile("^[1-9][0-9]*000$");
}
