package lotto.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> stringToStringList(String input) {
        return Arrays.asList(input.split(","));
    }

    public static String intToString(int input) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(input);
    }
}
