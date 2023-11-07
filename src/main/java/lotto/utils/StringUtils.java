package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static String formatCommaIntegerToString(int number) {
        return String.format("%,d", number);
    }

    public static List<Integer> asListByDelimiter(String winingNumbers, String delimiter) {
        List<Integer> list = new ArrayList<>();
        for (String str : winingNumbers.split(delimiter)) {
            list.add(Integer.valueOf(str));
        }
        return list;
    }
}
