package lotto.utils;

import java.util.regex.Pattern;

public class Constants {
    public static final int CNT_LOTTO_NUMBER = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int WINNING_NUMBERS_COUNT = 6;
    public static final String DELIMITER = ",";
    public static final int MATCH_COUNT_FOR_BONUS = 5;
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("^\\s*\\d+(\\s*,\\s*\\d+)*\\s*$");
}
