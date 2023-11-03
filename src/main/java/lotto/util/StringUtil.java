package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static int parseInt(String value) {
        try {
            validateBlank(value);
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해 주세요");
        }
    }

    public static List<Integer> parseComma(String comma) {
        List<Integer> result = new ArrayList<>();
        String[] split = comma.split(",", -1);

        for (String splitValue : split) {
            validateBlank(splitValue);
            result.add(parseInt(splitValue));
        }

        return result;
    }

    private static void validateBlank(String blank) {
        if (blank.isBlank()) {
            throw new IllegalArgumentException("빈 값은 허용하지 않습니다");
        }
    }
}
