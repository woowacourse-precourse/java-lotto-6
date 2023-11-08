package lotto.utils;

import static lotto.constant.ErrorMessage.INPUT_CONTAINS_WHITE_SPACE;
import static lotto.constant.ErrorMessage.INPUT_EMPTY;
import static lotto.constant.ErrorMessage.INPUT_IS_NOT_INTEGER;

public class StringUtils {
    public static void validEmptyString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException(INPUT_EMPTY);
        }
    }

    public static void validContainsWhiteSpace(String str) {
        if (str != null && str.contains(" ")) {
            throw new IllegalArgumentException(INPUT_CONTAINS_WHITE_SPACE);
        }
    }

    public static Integer getIntegerValue(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NOT_INTEGER);
        }
    }
}
