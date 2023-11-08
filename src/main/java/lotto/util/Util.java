package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static int changeStringToInt(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> changeStringToList(String number) {
        String[] numbersArray = number.split(",");
        List<Integer> result = new ArrayList<>();

        for (String num : numbersArray) {
            result.add(Integer.parseInt(num));
        }

        return result;
    }
}
