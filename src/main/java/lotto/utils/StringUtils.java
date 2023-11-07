package lotto.utils;

import static lotto.view.ErrorMessage.*;

public class StringUtils {

    public static int countOccurrences(String str, String target) {
        int count = 0;
        int idx = 0;

        while ((idx = str.indexOf(target, idx)) != -1) {
            idx += target.length();
            count++;
        }

        return count;
    }

    public static int parseInt(String str) {

        int result = 0;

        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getErrorMessage());
        }

        return result;
    }

}
