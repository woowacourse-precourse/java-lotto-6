package lotto.util;

import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern NUMBER_ALLOWED_PATTERN = Pattern.compile("\\D");

    private StringUtils() {

    }

    public static boolean isNumeric(String target) {
        if (NUMBER_ALLOWED_PATTERN.matcher(target).find()) {
            return false;
        }

        return true;
    }
}
