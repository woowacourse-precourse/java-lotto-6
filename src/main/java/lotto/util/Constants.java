package lotto.util;

import java.util.regex.Pattern;

public class Constants {
    public static final int MONEY_UNIT = 1000;
    public static final Pattern MONEY_PATTERN = Pattern.compile("^[1-9][0-9]*000$");
}
