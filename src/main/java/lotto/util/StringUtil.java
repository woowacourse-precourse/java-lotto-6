package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static List<Integer> parseComma(String comma) {
        List<Integer> result = new ArrayList<>();
        String[] split = comma.split(",", -1);

        for (String splitValue : split) {
            result.add(parseInt(splitValue));
        }

        return result;
    }
}
