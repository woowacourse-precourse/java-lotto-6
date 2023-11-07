package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern NUMBER_ALLOWED_PATTERN = Pattern.compile("\\D");
    private static final String NUMBER_SEPARATOR = ",";

    private StringUtils() {

    }

    public static boolean isNumeric(String target) {
        if (NUMBER_ALLOWED_PATTERN.matcher(target).find()) {
            return false;
        }

        return true;
    }

    public static List<Integer> convertStringToList(String target) {
        List<Integer> result = new ArrayList<>();

        String[] numbers = target.split(NUMBER_SEPARATOR);
        for (String number : numbers) {
            result.add(Integer.valueOf(number));
        }

        return result;
    }
}
