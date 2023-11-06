package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static String removeSpace(String string) {
        return string.replace(" ", "");
    }

    public static List<Integer> convertStringToInt(String string) {
        String[] splitString = string.split(",");
        List<Integer> stringToInt = new ArrayList<>();
        for (String s: splitString) {
            stringToInt.add(Integer.parseInt(s));
        }
        return stringToInt;
    }
}
