package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

    public static int stringToInteger(String original) {
        return Integer.parseInt(original);
    }

    public static List<Integer> stringToList(String original) {
        String[] nums = stringToSplit(original);
        List<Integer> convertNums = new ArrayList<>();

        for (String num : nums) {
            convertNums.add(Integer.parseInt(num));
        }

        return convertNums;
    }

    public static String[] stringToSplit(String original) {
        return original.split(",");
    }

    public static boolean is1And45(int number) {
        return (number >= 1 && number <= 45);
    }
}
