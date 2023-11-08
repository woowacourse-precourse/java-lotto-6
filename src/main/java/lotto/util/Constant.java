package lotto.util;

import java.util.regex.Pattern;

public class Constant {
    public static final int LOTTO_MIN_RANGE = 1;
    public static final int LOTTO_MAX_RANGE = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int LOTTO_PER_PRICE = 1000;
    public static final int PERCENT = 100;
    public static final String PERCENT_FORMAT = "%.1f";
    public static final int CHECK_BONUS_NUMBER = 7;
    public static final int SECOND_GET_MATCH_COUNT = 5;

    public static final String COMMA = ",";
    public static final String REGEX_SPACE = "\\s";
    public static final String REGEX_NOSPACE = "";
    public static final String REGEX_THOSAND_SEPARATOR = "\\B(?=(\\d{3})+(?!\\d))";
    public static final Pattern REGEX_NUMERIC = Pattern.compile("^[0-9]\\d*$");
    public static final Pattern REGEX_WINNING_NUMBERS_NUMERIC = Pattern.compile("^[0-9,\\s]+$");
}
